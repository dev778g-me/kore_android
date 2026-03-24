package com.dev.korelibrary.src.Components.ListItem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Themes.KoreTheme
import com.dev.korelibrary.src.Components.Themes.LocalContentColor
import com.dev.korelibrary.src.Components.Themes.LocalTextStyle


@Composable
fun ListTile(
    modifier: Modifier = Modifier,
    shape: Shape = ListTileDefaults.defaultListTileShape,
    colors: ListTileColors = ListTileDefaults.defaultListTileColors(),
    contentPaddingValues: PaddingValues = ListTileDefaults.defaultListItemPaddingValues,
    leadingAlignment: Alignment.Vertical = ListTileDefaults.defaultLeadingAlignment,
    trailingAlignment: Alignment.Vertical = ListTileDefaults.defaultTrailingAlignment,
    leading: (@Composable () -> Unit)? = null,
    trailing: (@Composable () -> Unit)? = null,
    overline: (@Composable () -> Unit)? = null,
    subtitle: (@Composable () -> Unit)? = null,
    title: @Composable () -> Unit,
) {
    val layoutDirection = LocalLayoutDirection.current
    val startPadding = contentPaddingValues.calculateStartPadding(layoutDirection)
    val endPadding = contentPaddingValues.calculateEndPadding(layoutDirection)
    val topPadding = contentPaddingValues.calculateTopPadding()
    val bottomPadding = contentPaddingValues.calculateBottomPadding()
    val itemSpacing = ListTileDefaults.itemSpacing
    val textSpacing = ListTileDefaults.textItemSpacing
    Layout(
        modifier = modifier
            .background(
                color = colors.containerColor,
                shape = shape
            ),
        content = {
            Box(Modifier.layoutId(ListTileContents.Title)) {
                CompositionLocalProvider(
                    values = arrayOf(
                        LocalTextStyle provides KoreTheme.typography.titleMedium,
                        LocalContentColor provides colors.titleContentColor
                    )
                ) {
                    title()
                }
            }
            subtitle?.let { Box(Modifier.layoutId(ListTileContents.Subtitle)) {
                CompositionLocalProvider(
                    values = arrayOf(
                        LocalTextStyle provides KoreTheme.typography.labelMedium,
                        LocalContentColor provides colors.subTitleContentColor
                    )
                ) {
                    it()
                }
            }
            }
            leading?.let {
                Box(Modifier.layoutId(ListTileContents.Leading)) {
                    CompositionLocalProvider(
                        value = LocalContentColor provides colors.leadingContentColor
                    ) { it() }
                }
            }
            trailing?.let {
                Box(Modifier.layoutId(ListTileContents.Trailing)) {
                    CompositionLocalProvider(
                        value = LocalContentColor provides colors.trailingContentColor
                    ) {
                        it()
                    }
                }
            }
            overline?.let {
                Box(Modifier.layoutId(ListTileContents.Overline)) {
                    CompositionLocalProvider(
                        values = arrayOf(
                            LocalTextStyle provides KoreTheme.typography.labelSmall,
                            LocalContentColor provides colors.overlineContentColor
                        )
                    ) {
                        it()
                    }
                }
            }
        }

    ) { measurables, constraints ->

       val  leadingPlaceable = measurables
           .firstOrNull { it.layoutId == ListTileContents.Leading }
           ?.measure(constraints = constraints.copy(minWidth = 0, minHeight = 0))

       val trailingPlaceable = measurables
           .firstOrNull {
               it.layoutId == ListTileContents.Trailing
           }?.measure(constraints = constraints.copy(minHeight = 0, minWidth = 0))

        val resolvedContentWidth = constraints.maxWidth
            .minus(leadingPlaceable?.width ?: 0)
            .minus(trailingPlaceable?.width ?: 0)
            .minus(startPadding.roundToPx())
            .minus(endPadding.roundToPx())
            .minus(if (leadingPlaceable != null) itemSpacing.roundToPx() else 0)
            .minus(if (trailingPlaceable != null) itemSpacing.roundToPx() else 0)
            .coerceAtLeast(0)

       val  maxWidth = resolvedContentWidth.coerceIn(0, constraints.maxWidth)

        // the column
        val titlePlaceable = measurables.firstOrNull {
            it.layoutId == ListTileContents.Title
        }?.measure(constraints = constraints.copy(minWidth = 0 , maxWidth = maxWidth))


        val subTitlePlaceable = measurables.firstOrNull {
            it.layoutId == ListTileContents.Subtitle
        }?.measure(constraints = constraints.copy(minWidth = 0, maxWidth = maxWidth))

        val overlinePlaceable = measurables.firstOrNull {
            it.layoutId == ListTileContents.Overline
        }?.measure(constraints = constraints.copy(minWidth = 0, maxWidth = maxWidth))

        val overlineTitleSpacing = if (overlinePlaceable !=null) textSpacing.roundToPx() else 0
        val titleSubtitleSpacing = if (subTitlePlaceable != null) textSpacing.roundToPx() else 0

        val textColumnHeight =
            (overlinePlaceable?.height ?: 0) + overlineTitleSpacing +
                    (titlePlaceable?.height ?: 0) + titleSubtitleSpacing +
                    (subTitlePlaceable?.height ?: 0)

        val maxHeight = maxOf(
            a = leadingPlaceable?.height ?:0,
            b = trailingPlaceable?.height ?:0,
            c = textColumnHeight,
        ).plus(topPadding.roundToPx()).plus(bottomPadding.roundToPx())


        layout(height = maxHeight, width = constraints.maxWidth) {

            val leadingX = startPadding.roundToPx()
            leadingPlaceable?.place(
                x = leadingX,
                y = topPadding.roundToPx() + leadingAlignment.align(
                    size = leadingPlaceable.height,
                    space = maxHeight - (topPadding.roundToPx() + bottomPadding.roundToPx())
                )
            )


            // start of column
            val textStartX = leadingX +
                    (leadingPlaceable?.width ?: 0) +
                    (if (leadingPlaceable != null) itemSpacing.roundToPx() else 0)


           // y coordinates
            var currentY = topPadding.roundToPx() +
                    (maxHeight - topPadding.roundToPx() - bottomPadding.roundToPx() - textColumnHeight) / 2


            // overline
            overlinePlaceable?.place(
                x = textStartX,
                y = currentY
            )

            currentY += (overlinePlaceable?.height?:0) + overlineTitleSpacing
            // title
            titlePlaceable?.place(
                x = textStartX,
                y = currentY
            )

            currentY += (titlePlaceable?.height ?: 0) + titleSubtitleSpacing

            subTitlePlaceable?.place(
                x = textStartX,
                y = currentY
            )


           //
            trailingPlaceable?.place(
                x = (constraints.maxWidth - endPadding.roundToPx()) - trailingPlaceable.width,
                y =  topPadding.roundToPx().plus(
                    trailingAlignment.align(
                        size = trailingPlaceable.height,
                        space = maxHeight.minus(topPadding.roundToPx() + bottomPadding.roundToPx())
                    )
                )
            )


        }
    }

}




object ListTileDefaults{

    @Composable
    fun defaultListTileColors(
        containerColor: Color= KoreTheme.colorScheme.surface,
        titleContentColor: Color= KoreTheme.colorScheme.onBackGround,
        subTitleContentColor: Color= KoreTheme.colorScheme.onBackGroundVariant,
        overlineContentColor : Color= KoreTheme.colorScheme.onBackGroundVariant,
        leadingContentColor : Color= KoreTheme.colorScheme.onSurface,
        trailingContentColor : Color= KoreTheme.colorScheme.onSurface,
    ) = ListTileColors(
        containerColor = containerColor,
        titleContentColor = titleContentColor,
        subTitleContentColor = subTitleContentColor,
        overlineContentColor = overlineContentColor,
        leadingContentColor = leadingContentColor,
        trailingContentColor = trailingContentColor
    )


    val defaultTrailingAlignment : Alignment.Vertical = Alignment.CenterVertically

    val defaultLeadingAlignment : Alignment.Vertical = Alignment.CenterVertically


   val defaultListItemPaddingValues : PaddingValues = PaddingValues(
       horizontal = 16.dp,
       vertical = 12.dp
   )

   val defaultListTileShape  : Shape
       @Composable get() = KoreTheme.shapes.medium




    val textItemSpacing = 4.dp




    val itemSpacing = 8.dp
}



enum class ListTileContents{
    Leading,
    Title,
    Subtitle,
    Overline,
    Trailing
}




data class ListTileColors(
    val containerColor : Color,
    val titleContentColor : Color,
    val subTitleContentColor : Color,
    val overlineContentColor : Color,
    val leadingContentColor : Color,
    val trailingContentColor : Color,

)







