package com.dev.korelibrary.src.Components.Buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Themes.KoreTheme
import com.dev.korelibrary.src.Components.Themes.LocalContentColor
import com.dev.korelibrary.src.Components.Themes.LocalKoreShapes
import com.dev.korelibrary.src.Components.Themes.LocalKoreSizes
import com.dev.korelibrary.src.Components.Themes.LocalTextStyle


// enum class for the button sizes
enum class ButtonSizes{
    Large,
    Medium,
    Normal,
    Small
}

//base button for reuse <idk>

@Composable
internal fun BaseButton (
    onClick : () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    buttonSize: ButtonSizes,
    buttonPadding: PaddingValues,
    buttonColors: ButtonColors,
    border : BorderStroke ? = null,
    shape: Shape,
    content: @Composable RowScope.() -> Unit
){
    CompositionLocalProvider(
        LocalTextStyle provides TextStyle.Default.merge(
            when(buttonSize){
                ButtonSizes.Small -> KoreTheme.typography.labelMedium
                ButtonSizes.Normal -> KoreTheme.typography.titleSmall
                ButtonSizes.Medium -> KoreTheme.typography.titleMedium
                ButtonSizes.Large -> KoreTheme.typography.headingSmall
            }
        ),
        LocalContentColor provides if (enabled) buttonColors.buttonContentColor else buttonColors.disabledButtonContentColor
    ) {
        Row(
            modifier = modifier
                .clip(shape = shape)
                .background(
                    color = if (enabled) buttonColors.buttonContainerColor else buttonColors.disabledButtonContainerColor,
                    shape = shape
                )
                .then(
                    if (border != null) Modifier.border(
                        border = border,
                        shape = shape
                    ) else Modifier
                )
                .clickable(
                    enabled = enabled,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = LocalIndication.current,
                    role = Role.Button,
                    onClick = {
                        onClick.invoke()
                    }
                )
                .padding(buttonPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            content()
        }
    }
}



// primary button -- should be used for primary action
@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonSize: ButtonSizes = ButtonSizes.Normal,
    buttonPadding: PaddingValues? =null,
    buttonColors: ButtonColors = ButtonDefaults.primaryButtonColors(),
    shape: Shape = KoreTheme.shapes.normal,
    content: @Composable RowScope.() -> Unit
) {
   val resolvedPadding = buttonPadding ?: when (buttonSize) {
        ButtonSizes.Small -> ButtonDefaults.extraSmallPadding()
        ButtonSizes.Normal -> ButtonDefaults.smallButtonPadding()
        ButtonSizes.Medium -> ButtonDefaults.mediumButtonPadding()
        ButtonSizes.Large -> ButtonDefaults.largeButtonPadding()
    }
    BaseButton(
        onClick = onClick,
        modifier =modifier,
        enabled = enabled,
        buttonSize = buttonSize,
        buttonPadding = resolvedPadding,
        buttonColors = buttonColors,
        shape = shape,
        content = content
    )
}




// Secondary button should be used for the seondary task i.e - less important than the primary task on the screen


@Composable
fun SecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonSize: ButtonSizes = ButtonSizes.Normal,
    buttonPadding: PaddingValues? = null,
    buttonColors: ButtonColors = ButtonDefaults.secondaryButtonColors(),
    shape: Shape = KoreTheme.shapes.normal,
    content: @Composable RowScope.() -> Unit
) {
    val resolvedPadding = buttonPadding ?: when (buttonSize) {
        ButtonSizes.Small -> ButtonDefaults.extraSmallPadding()
        ButtonSizes.Normal -> ButtonDefaults.smallButtonPadding()
        ButtonSizes.Medium -> ButtonDefaults.mediumButtonPadding()
        ButtonSizes.Large -> ButtonDefaults.largeButtonPadding()
    }
    BaseButton(
        onClick = onClick,
        modifier =modifier,
        enabled = enabled,
        buttonSize = buttonSize,
        buttonPadding = resolvedPadding,
        buttonColors = buttonColors,
        shape = shape,
        content = content
    )
}


// outlined Button for more less important tasks

@Composable
fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonSize: ButtonSizes = ButtonSizes.Normal,
    buttonPadding: PaddingValues ? = null,
    buttonColors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    shape: Shape = KoreTheme.shapes.normal,
    content: @Composable RowScope.() -> Unit
) {
    val resolvedPadding = buttonPadding ?: when (buttonSize) {
        ButtonSizes.Small -> ButtonDefaults.extraSmallPadding()
        ButtonSizes.Normal -> ButtonDefaults.smallButtonPadding()
        ButtonSizes.Medium -> ButtonDefaults.mediumButtonPadding()
        ButtonSizes.Large -> ButtonDefaults.largeButtonPadding()
    }
    BaseButton(
        onClick = onClick,
        modifier =modifier,
        enabled = enabled,
        buttonSize = buttonSize,
        buttonPadding = resolvedPadding,
        buttonColors = buttonColors,
        shape = shape,
        border = BorderStroke(width = 1.dp, color =if (enabled) buttonColors.buttonContentColor else buttonColors.disabledButtonContentColor),
        content = content
    )
}


// ghost buttons used for very less important task on the screen 

@Composable
fun GhostButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonSize: ButtonSizes = ButtonSizes.Normal,
    buttonPadding: PaddingValues? = null,
    buttonColors: ButtonColors = ButtonDefaults.ghostButtonColors(),
    shape: Shape = KoreTheme.shapes.normal,
    content: @Composable RowScope.() -> Unit
) {
    val resolvedPadding = buttonPadding ?: when (buttonSize) {
        ButtonSizes.Small -> ButtonDefaults.extraSmallPadding()
        ButtonSizes.Normal -> ButtonDefaults.smallButtonPadding()
        ButtonSizes.Medium -> ButtonDefaults.mediumButtonPadding()
        ButtonSizes.Large -> ButtonDefaults.largeButtonPadding()
    }
    BaseButton(
        onClick = onClick,
        modifier =modifier,
        enabled = enabled,
        buttonSize = buttonSize,
        buttonPadding = resolvedPadding,
        buttonColors = buttonColors,
        shape = shape,
        content = content
    )
}





object ButtonDefaults{

    /// color value for the primary button
    @Composable
    fun primaryButtonColors(
        containerColor : Color = KoreTheme.colorScheme.primary,
        contentColor: Color = KoreTheme.colorScheme.onPrimary,
        disabledButtonContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledButtonContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ButtonColors(
        buttonContainerColor = containerColor,
        buttonContentColor = contentColor,
        disabledButtonContainerColor = disabledButtonContainerColor,
        disabledButtonContentColor = disabledButtonContentColor,
    )

    @Composable
    fun secondaryButtonColors (
        containerColor: Color = KoreTheme.colorScheme.primaryContainer,
        contentColor : Color = KoreTheme.colorScheme.onPrimaryContainer,
        disabledButtonContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledButtonContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ButtonColors(
        buttonContainerColor = containerColor,
        buttonContentColor = contentColor,
        disabledButtonContainerColor = disabledButtonContainerColor,
        disabledButtonContentColor =disabledButtonContentColor
    )

    @Composable
    fun outlinedButtonColors(
        containerColor: Color = KoreTheme.colorScheme.transParentColor,
        contentColor: Color = KoreTheme.colorScheme.primary,
        disabledButtonContainerColor: Color = KoreTheme.colorScheme.transParentColor,
        disabledButtonContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ButtonColors(
        buttonContainerColor = containerColor,
        buttonContentColor = contentColor,
        disabledButtonContainerColor =disabledButtonContainerColor ,
        disabledButtonContentColor = disabledButtonContentColor
    )


    @Composable
    fun ghostButtonColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = KoreTheme.colorScheme.primary,
        disabledButtonContainerColor: Color = KoreTheme.colorScheme.transParentColor,
        disabledButtonContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ButtonColors(
        buttonContainerColor = containerColor,
        buttonContentColor = contentColor,
        disabledButtonContainerColor = disabledButtonContainerColor,
        disabledButtonContentColor = disabledButtonContentColor
    )

    // extra small button padding values
    @Composable
    fun extraSmallPadding(
        buttonPadding: PaddingValues = PaddingValues(
            horizontal = KoreTheme.sizes.small,
            vertical = KoreTheme.sizes.extraSmall
        )
    ) = buttonPadding

    // color value for the s

    @Composable
    fun smallButtonPadding(
        buttonPadding : PaddingValues = PaddingValues(
            horizontal = LocalKoreSizes.current.medium,
            vertical = LocalKoreSizes.current.small
        )
    ) = buttonPadding


    @Composable
    fun mediumButtonPadding (
        buttonPadding: PaddingValues = PaddingValues(
            horizontal = KoreTheme.sizes.medium,
            vertical = KoreTheme.sizes.normal
        )
    ) = buttonPadding

    @Composable
    fun largeButtonPadding(
        buttonPadding: PaddingValues = PaddingValues(
            horizontal = KoreTheme.sizes.large,
            vertical = KoreTheme.sizes.medium,

        )
    ) = buttonPadding
}





@Immutable
data class ButtonColors(
    val buttonContainerColor : Color,
    val buttonContentColor : Color,
    val disabledButtonContainerColor : Color,
    val disabledButtonContentColor: Color
)