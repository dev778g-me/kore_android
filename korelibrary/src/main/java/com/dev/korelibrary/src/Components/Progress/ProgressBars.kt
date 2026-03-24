package com.dev.korelibrary.src.Components.Progress

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Themes.KoreTheme
import com.dev.korelibrary.src.Components.Themes.Ripple.Logger

@Composable
fun LinearProgressBar(
    progress : Float,
    modifier: Modifier = Modifier,
    thickness : Dp = ProgressDefaults.defaultProgressBarThickness,
    cap : StrokeCap = ProgressDefaults.defaultProgressBarCap,
    colors: BarProgressColors = ProgressDefaults.barProgressColors(),
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
        val strokeWidthPx = thickness.toPx()

        val inset = if (cap == StrokeCap.Butt) 0f else strokeWidthPx /2

        val endX = size.width - inset
        val drawableWidth = endX - inset


        // track of the barrrrrrrrr

        drawLine(
            cap = StrokeCap.Round,
            color = trackColor,
            strokeWidth = thickness.toPx(),
            start = Offset(x = inset, y =  yCenter),
            end = Offset(x = endX, y = yCenter)
        )
        val progressWidth =( drawableWidth * resolvedProgress) + inset

        if (resolvedProgress >0){

            drawLine(
                cap = StrokeCap.Round,
                color = progressColor,
                strokeWidth = thickness.toPx(),
                start = Offset(x = inset, y =  yCenter),
                end = Offset(x = progressWidth, y = yCenter)
            )
        }

    }







}






@Composable
fun CircularProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    thickness: Dp = ProgressDefaults.defaultCircularBarThickness,
    size : Dp = ProgressDefaults.defaultCircularProgressBarSize,
    cap: StrokeCap = ProgressDefaults.defaultProgressBarCap,
    colors: BarProgressColors = ProgressDefaults.circularProgressColors()
){


    val coercedProgress = (progress /100f).coerceIn(0f..1f)
    Canvas(
        modifier = modifier
            .size(size)
            .padding(thickness /2)
    ) {
        drawArc(
            color = colors.trackColor,
            style = Stroke(width = thickness.value, cap = cap),
            startAngle =  -90f,
            sweepAngle =  360f,
            useCenter = false
        )
      drawArc(
          color = colors.progressColor,
          style = Stroke(width = thickness.value, cap = cap),
          startAngle =  -90f,
          sweepAngle = coercedProgress * 360f,
          useCenter = false
      )
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


    val defaultCircularBarThickness = 12.dp

    val defaultCircularProgressBarSize = 48.dp

    val defaultProgressBarCap : StrokeCap = StrokeCap.Round
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

    @Composable
    fun circularProgressColors(
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