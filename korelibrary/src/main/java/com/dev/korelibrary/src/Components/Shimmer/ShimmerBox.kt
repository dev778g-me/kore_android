package com.dev.korelibrary.src.Components.Shimmer

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.dev.korelibrary.src.Components.Modifiers.shimmer
import com.dev.korelibrary.src.Components.Themes.KoreShapes
import com.dev.korelibrary.src.Components.Themes.KoreTheme

@Composable
fun ShimmerBox(
    modifier: Modifier = Modifier,
    shape: Shape = KoreTheme.shapes.medium,
    content : (@Composable ()-> Unit)? = null
) {

    Box(
        modifier = modifier
            .shimmer(
                shape = shape
            )
    ){
       content?.invoke()
    }

}