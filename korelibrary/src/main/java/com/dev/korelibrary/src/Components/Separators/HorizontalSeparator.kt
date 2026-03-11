package com.dev.korelibrary.src.Components.Separators

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Themes.KoreTheme

@Composable
fun HorizontalSeparator(
    modifier: Modifier = Modifier,
    thickness : Dp= SeparatorDefaults.defaultSeparatorThickness,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    color : Color= KoreTheme.colorScheme.backGroundVariant
) {
    val density = LocalDensity.current
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
    ){
        drawLine(
            cap = separatorCap,
            color = color,
            strokeWidth = with(density) {
                thickness.toPx()
            },
            start = Offset(x = 0f, y = thickness.toPx()/2),
            end = Offset(x = size.width, y = thickness.toPx()/2)
        )
    }
}


@Composable
fun VerticalSeparator(
    modifier: Modifier = Modifier,
    thickness: Dp = SeparatorDefaults.defaultSeparatorThickness,
    separatorCap: StrokeCap = SeparatorDefaults.defaultSeparatorCap,
    color: Color = KoreTheme.colorScheme.backGroundVariant
) {
    Canvas(modifier = modifier.fillMaxHeight().width(thickness)) {
        drawLine(
            cap = separatorCap,
            color = color,
            strokeWidth = thickness.toPx(),
            start = Offset(x = thickness.toPx()/2, y = 0f),
            end = Offset(x = thickness.toPx()/2, y =size.height)
        )
    }
}







object SeparatorDefaults{
    val defaultSeparatorThickness = 1.dp

    val defaultSeparatorCap : StrokeCap = StrokeCap.Round

    @Composable
    fun defaultSeparatorColor(
        separatorColor: Color = KoreTheme.colorScheme.backGroundVariant
    ) = SeparatorColors(
        separatorColor = separatorColor
    )
}

data class SeparatorColors(
    val separatorColor: Color
)