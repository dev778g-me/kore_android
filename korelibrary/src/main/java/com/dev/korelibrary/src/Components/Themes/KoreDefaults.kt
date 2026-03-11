package com.dev.korelibrary.src.Components.Themes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.jadu.nivi.presentation.utils.squircleShape.SquircleShape

object KoreDefaults{
    val defaultLightColorScheme = KoreColors(
        // background and background variant
        background = RadixColors.Gray.Light.step1,
        onBackGround = RadixColors.Black.blackA12,

        backGroundVariant = RadixColors.Gray.Light.step4,
        onBackGroundVariant = RadixColors.Gray.Light.step11,
        accent = RadixColors.Blue.Light.step4,
        // disabled colors
        disabled = RadixColors.Gray.Light.step3,
        onDisabled = RadixColors.Gray.Light.step8,

        // primary colors
        primary = RadixColors.Blue.Light.step9,
        onPrimary = RadixColors.Blue.Light.step2,

        primaryContainer = RadixColors.Blue.Light.step5,
        onPrimaryContainer = RadixColors.Blue.Light.step10,

        secondary = TailwindColors.Sky500,
        onSecondary = TailwindColors.Sky100,
        secondaryContainer = TailwindColors.Sky300,
        onSecondaryContainer = TailwindColors.Sky900,



        // success colors
        success = RadixColors.Green.Light.step9,
        onSuccess = RadixColors.Green.Light.step3,

        // error colors
        error = RadixColors.Red.Light.step9,
        onError = RadixColors.Red.Light.step3,
        transParentColor = Color.Transparent
    )


    val defaultDarkColorScheme = KoreColors(
        // background and background variant
        background = RadixColors.Gray.Dark.step1,
        onBackGround = RadixColors.White.whiteA12,

        backGroundVariant = RadixColors.Gray.Dark.step4,
        onBackGroundVariant = RadixColors.Gray.Dark.step11,
        accent = RadixColors.Blue.Dark.step1,
        // disabled colors
        disabled = RadixColors.Gray.Dark.step3,
        onDisabled = RadixColors.Gray.Dark.step8,

        // primary colors
        primary = RadixColors.Blue.Dark.step9,
        onPrimary = RadixColors.Blue.Dark.step12,

        primaryContainer = RadixColors.Blue.Dark.step3,
        onPrimaryContainer = RadixColors.Blue.Dark.step10,

        secondary = TailwindColors.Sky600,
        onSecondary = TailwindColors.Sky900,
        secondaryContainer = TailwindColors.Sky700,
        onSecondaryContainer = TailwindColors.Blue700,



        // success colors
        success = RadixColors.Green.Dark.step9,
        onSuccess = RadixColors.Green.Dark.step12,

        // error colors
        error = RadixColors.Red.Dark.step9,
        onError = RadixColors.Red.Dark.step12,
        transParentColor = Color.Transparent
    )


    val defaultTypography = KoreTypography(
        // Display styles (largest)
        displayLarge = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Normal,
            fontSize = 57.sp,
            lineHeight = 64.sp,
            letterSpacing = (-0.25).sp   // M3: -0.25sp
        ),
        displayMedium = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Normal,
            fontSize = 45.sp,
            lineHeight = 52.sp,
            letterSpacing = 0.sp          // M3: 0sp ✓
        ),
        displaySmall = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Normal,
            fontSize = 36.sp,
            lineHeight = 44.sp,
            letterSpacing = 0.sp          // M3: 0sp ✓
        ),

        // Headline styles
        headingLarge = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Normal,   // M3: Normal (not Bold)
            fontSize = 32.sp,
            lineHeight = 40.sp,
            letterSpacing = 0.sp              // M3: 0sp ✓
        ),
        headingMedium = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Normal,   // M3: Normal (not Bold)
            fontSize = 28.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp              // M3: 0sp ✓
        ),
        headingSmall = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Normal,   // M3: Normal (not Medium)
            fontSize = 24.sp,
            lineHeight = 32.sp,
            letterSpacing = 0.sp              // M3: 0sp ✓
        ),

        // Title styles
        titleLarge = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Normal,   // M3: Normal ✓
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp              // M3: 0sp ✓
        ),
        titleMedium = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Medium,   // M3: Medium (not Normal)
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp           // M3: 0.15sp ✓
        ),
        titleSmall = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Medium,   // M3: Medium ✓
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp            // M3: 0.1sp ✓
        ),

        // Body styles
        bodyLarge = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Normal,   // M3: Normal ✓
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp            // M3: 0.5sp (not 0.15sp)
        ),
        bodyMedium = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Normal,   // M3: Normal ✓
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp           // M3: 0.25sp ✓
        ),
        bodySmall = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Normal,   // M3: Normal ✓
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.4.sp            // M3: 0.4sp ✓
        ),

        // Label styles
        labelLarge = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Medium,   // M3: Medium (not SemiBold)
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp            // M3: 0.1sp ✓
        ),
        labelMedium = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Medium,   // M3: Medium (not SemiBold)
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp            // M3: 0.5sp ✓
        ),
        labelSmall = TextStyle(
            fontFamily = googleSansFlex,
            fontWeight = FontWeight.Medium,   // M3: Medium (not SemiBold)
            fontSize = 11.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp            // M3: 0.5sp ✓
        )
    )


    val defaultShapes = KoreShapes(
        extraLarge = RoundedCornerShape(34.dp),
        large = RoundedCornerShape(24.dp),
        medium = RoundedCornerShape(16.dp),
        normal = RoundedCornerShape(12.dp),
        small = RoundedCornerShape(8.dp)
    )

    val defaultSquircleShapes = KoreShapes(
        extraLarge = SquircleShape(34.dp),
        large = SquircleShape(24.dp),
        medium = SquircleShape(16.dp),
        normal = SquircleShape(12.dp),
        small = SquircleShape(8.dp)
    )

    val defaultSizes = KoreSizes(
        extraLarge = 34.dp,
        large = 24.dp,
        medium = 16.dp,
        normal = 12.dp,
        small = 8.dp,
        extraSmall = 4.dp
    )


}



