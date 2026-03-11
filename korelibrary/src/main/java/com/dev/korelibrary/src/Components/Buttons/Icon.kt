package com.dev.korelibrary.src.Components.Buttons

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import com.dev.korelibrary.src.Components.Themes.LocalContentColor

enum class IconButtonSizes{
    Small,
    Normal,
    Medium,
    Large
}

// icon is a composable function that's let's user display an icon

@Composable
fun Icon(
    imageVector: ImageVector,
    contentDescription: String?,
    tint: Color  = LocalContentColor.current,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Image(
        painter = rememberVectorPainter(imageVector),
        contentDescription = contentDescription,
        colorFilter = ColorFilter.tint(
            color = tint,
            blendMode = BlendMode.SrcIn
        ),
        modifier = modifier
    )
}
