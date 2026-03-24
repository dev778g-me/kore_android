package com.dev.korelibrary.src.Components.Tabrow

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Themes.KoreTheme
import com.dev.korelibrary.src.Components.Themes.LocalContentColor
import kotlinx.coroutines.launch

@Composable
fun TabRow(
    selectedIndex : Int,
    modifier: Modifier = Modifier,
    indicatorColor: Color = KoreTheme.colorScheme.primary,
    indicatorShape: Shape = TabRowDefaults.defaultIndicatorShape,
    indicator: @Composable (tabPositions: List<TabPosition>) -> Unit = { tabPositions ->
        TabIndicator(tabPositions[selectedIndex], indicatorColor = indicatorColor, shape = indicatorShape)
    },
    shape: Shape = TabRowDefaults.defaultTabRowShape,
    containerColor : Color = KoreTheme.colorScheme.backGroundVariant,
    tabs: @Composable () -> Unit,
) {
    val scrollState = rememberScrollState()
    val density = LocalDensity.current
    val scope = rememberCoroutineScope()
    var newPositions by remember { mutableStateOf(listOf<TabPosition>()) }

    LaunchedEffect(selectedIndex, newPositions) {
        if (newPositions.isNotEmpty() && selectedIndex in newPositions.indices){
            val targetPos = newPositions[selectedIndex]
            val scrollOffset = with(density){
                targetPos.left.roundToPx()
            }

            scope.launch {
                scrollState.animateScrollTo(scrollOffset)
            }
        }
    }


        SubcomposeLayout(
            modifier = modifier
                .background(
                    color = containerColor,
                    shape = shape
                )
                .horizontalScroll(
                    state = scrollState
                ).selectableGroup()
                .clipToBounds()
                .padding(TabRowDefaults.defaultTabRowPaddingValues)
        ) { constraints ->

            val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)


            val tabPlaceable = subcompose(slotId = TabRowItem.Tab, content = tabs).map { measurable ->
             measurable.measure(looseConstraints)
         }

         var currentLeft = 0
         val tabPosition = tabPlaceable
             .map { placeable ->
                 val position =
                     TabPosition(left = currentLeft.toDp(), width = placeable.width.toDp())
                 currentLeft += placeable.width
                 position
             }

            if (tabPosition != newPositions){
                newPositions = tabPosition
            }


         val totalWidth = tabPlaceable.sumOf { it.width }
         val maxHeight = tabPlaceable.maxOfOrNull { it.height } ?: 0

         val indicatorPlaceable = subcompose(slotId = TabRowItem.Indicator) {
             indicator(tabPosition)
         }.map {
             it.measure(
                 constraints = Constraints.fixed(
                     width = totalWidth,
                     height = maxHeight
                 )
             )
         }



         layout(width = totalWidth, height = maxHeight){

             indicatorPlaceable.forEach { placeable ->
                 placeable.placeRelative(x = 0, y = 0)
             }

             var  x = 0
             tabPlaceable.forEach { placeable ->
                 placeable.placeRelative(x = x, y = 0)
                 x += placeable.width
             }

         }

     }
 }



@Composable
internal fun TabIndicator(
    tabPosition: TabPosition,
    modifier: Modifier = Modifier,
    indicatorColor: Color,
    shape: Shape,
) {
    val offsetAnim by animateDpAsState(
        targetValue = tabPosition.left,

        label = "indicator_offset"
    )
    val widthAnim by animateDpAsState(
        targetValue = tabPosition.width,
        label = "indicator_width"
    )



    Box(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = offsetAnim)
                .width(widthAnim)
                .fillMaxHeight()
                .background(
                    color = indicatorColor,
                    shape = shape
                )
        )
    }
}



@Composable
fun Tab(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    icon: (@Composable () -> Unit)? = null,
    isSelected: Boolean,
    enabled: Boolean = true,
    shape: Shape = TabRowDefaults.defaultTabShape,
    selectedContentColor: Color = KoreTheme.colorScheme.onPrimary,
    unselectedContentColor: Color = KoreTheme.colorScheme.onBackGround,
    horizontalTabSpacing : Dp = TabRowDefaults.defaultHorizontalTabSpacing,
    onClick: () -> Unit,
) {
    val contentColor by animateColorAsState(
        targetValue = if (isSelected) selectedContentColor else unselectedContentColor
    )

    Box(
        modifier = modifier
            .padding(horizontal = horizontalTabSpacing)
            .clip(shape)
            .clickable(
                enabled = enabled,
                onClick = onClick
            )
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            Row(
                modifier = Modifier
                    .padding(TabRowDefaults.defaultTabPadding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                icon?.let {
                    Box(modifier = Modifier.padding(end = 4.dp)) { it() }
                }
                content()
            }
        }
    }
}



internal enum class TabRowItem{
    Tab,
    Indicator
}

object TabRowDefaults{

    val defaultTabRowShape : Shape
        @Composable get() = KoreTheme.shapes.medium
    val defaultTabRowPaddingValues = PaddingValues(
        all = 4.dp
    )
    val defaultTabShape : Shape
        @Composable get() = KoreTheme.shapes.normal
    val defaultIndicatorShape : Shape
        @Composable get() = KoreTheme.shapes.normal


    val defaultTabRowHeight = 2.dp

    val defaultHorizontalTabSpacing : Dp = 4.dp
    val defaultTabPadding : PaddingValues = PaddingValues(
        horizontal = 12.dp,
        vertical = 4.dp
    )






}

@Immutable
data class TabPosition(val left: Dp, val width: Dp)







