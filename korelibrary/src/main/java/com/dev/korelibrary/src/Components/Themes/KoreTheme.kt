package com.dev.korelibrary.src.Components.Themes

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.dev.korelibrary.src.Components.Themes.KoreDefaults.defaultDarkColorScheme
import com.dev.korelibrary.src.Components.Themes.KoreDefaults.defaultLightColorScheme
import com.dev.korelibrary.src.Components.Themes.KoreDefaults.defaultShapes
import com.dev.korelibrary.src.Components.Themes.KoreDefaults.defaultSizes
import com.dev.korelibrary.src.Components.Themes.KoreDefaults.defaultSquircleShapes
import com.dev.korelibrary.src.Components.Themes.KoreDefaults.defaultTypography
import com.dev.korelibrary.src.Components.Themes.Ripple.koreRipple

@Immutable
data class KoreColors(
    // background
    val background: Color,
    val onBackGround: Color,
    val backGroundVariant: Color,
    val onBackGroundVariant: Color,

    // surface
    val surface: Color,
    val onSurface: Color,
    val surfaceBright: Color,
    val onSurfaceBright: Color,

    // primary
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,

    // secondary
    val secondary: Color,
    val onSecondary: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,

    // semantic
    val success: Color,
    val onSuccess: Color,
    val error: Color,
    val onError: Color,

    // misc
    val accent: Color,
    val disabled: Color,
    val onDisabled: Color,
    val transParentColor: Color,
)

@Immutable
data class KoreTypography(
    val headingLarge : TextStyle,
    val headingMedium : TextStyle,
    val headingSmall : TextStyle,
    val displayLarge : TextStyle,
    val displayMedium : TextStyle,
    val displaySmall : TextStyle,
    val titleLarge : TextStyle,
    val titleMedium : TextStyle,
    val titleSmall : TextStyle,
    val bodyLarge : TextStyle,
    val bodyMedium : TextStyle,
    val bodySmall : TextStyle,
    val labelLarge : TextStyle,
    val labelMedium : TextStyle,
    val labelSmall : TextStyle
)

@Immutable
data class KoreShapes(
    val extraLarge: Shape,
    val large: Shape,
    val medium: Shape,
    val normal: Shape,
    val small: Shape
)

@Immutable
data class KoreSizes(
    val extraLarge : Dp,
    val large : Dp,
    val medium : Dp,
    val normal : Dp,
    val small : Dp,
    val extraSmall : Dp
)

val LocalKoreColorScheme = staticCompositionLocalOf {
    defaultLightColorScheme
}


val LocalKoreTypography = staticCompositionLocalOf {
   defaultTypography
}

val LocalKoreShapes = staticCompositionLocalOf {
    defaultShapes
}

val LocalKoreSizes = staticCompositionLocalOf {
    defaultSizes
}

val LocalTextStyle = staticCompositionLocalOf { defaultTypography.titleSmall }


val LocalContentColor = staticCompositionLocalOf { defaultLightColorScheme.onBackGround }

@Composable
fun KoreTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    defaultShapes: KoreShapes = KoreDefaults.defaultShapes,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDark) defaultDarkColorScheme else defaultLightColorScheme
    val rippleIndication = remember(colorScheme) {
        koreRipple(
            color = colorScheme.onBackGround
        )
    }

    CompositionLocalProvider(
        LocalKoreColorScheme provides colorScheme,
        LocalContentColor provides colorScheme.onBackGround,
        LocalKoreTypography provides defaultTypography,
        LocalTextStyle provides defaultTypography.titleSmall,
        LocalIndication provides rippleIndication,
        LocalKoreShapes provides defaultShapes,
        LocalKoreSizes provides defaultSizes,
        content = content
    )

}




object KoreTheme {
    val colorScheme : KoreColors
        @Composable get() = LocalKoreColorScheme.current

    val typography : KoreTypography
        @Composable get() = LocalKoreTypography.current

    val shapes : KoreShapes
        @Composable get() = LocalKoreShapes.current

    val sizes : KoreSizes
        @Composable get() = LocalKoreSizes.current
}