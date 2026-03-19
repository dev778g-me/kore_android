package com.dev.korelibrary.src.Components.Progress

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Themes.KoreTheme

@Composable
fun LinearProgressBar(
    modifier: Modifier = Modifier,
    thickness : Dp = ProgressDefaults.defaultProgressBarThickness,
    colors: BarProgressColors = ProgressDefaults.barProgressColors(),
    progress : Float,
) {




    val resolvedProgress = (progress /100f).coerceIn( 0f ..1f)

    val trackColor by animateColorAsState(
        targetValue = colors.trackColor(enabled = true)
    )

    val progressColor by animateColorAsState(
        targetValue = colors.progressColor(enabled = true)
    )

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
    ) {
        val yCenter = size.height/2
        val startX = thickness.toPx() / 2
        val endX = size.width - (thickness.toPx() / 2)
        val drawableWidth = endX - startX


        // track of the barrrrrrrrr

        drawLine(
            cap = StrokeCap.Round,
            color = trackColor,
            strokeWidth = thickness.toPx(),
            start = Offset(x = 0f, y =  yCenter),
            end = Offset(x = drawableWidth, y = yCenter)
        )
        val progressWidth = drawableWidth * resolvedProgress

        if (resolvedProgress >0){

            drawLine(
                cap = StrokeCap.Round,
                color = progressColor,
                strokeWidth = thickness.toPx(),
                start = Offset(x = 0f, y =  yCenter),
                end = Offset(x = progressWidth, y = yCenter)
            )
        }

    }







}






@Immutable
data class BarProgressColors(
    val trackColor : Color,
    val progressColor : Color,
    val disabledTrackColor : Color,
    val disabledProgressColor : Color,
)

private fun BarProgressColors.trackColor(enabled : Boolean) : Color{
   return if (enabled) this.trackColor else this.disabledTrackColor
}


private fun BarProgressColors.progressColor(enabled: Boolean) : Color{
   return if (enabled) this.progressColor else this.disabledTrackColor
}




object ProgressDefaults{

    val defaultProgressBarThickness = 4.dp

   @Composable
    fun barProgressColors(
        trackColor: Color = KoreTheme.colorScheme.backGroundVariant,
        progressColor: Color = KoreTheme.colorScheme.primary,
        disabledTrackColor: Color = KoreTheme.colorScheme.disabled,
        disabledProgressColor: Color = KoreTheme.colorScheme.onDisabled,
    ) = BarProgressColors(
        trackColor = trackColor,
        progressColor = progressColor,
        disabledTrackColor = disabledTrackColor,
        disabledProgressColor = disabledProgressColor
    )

}