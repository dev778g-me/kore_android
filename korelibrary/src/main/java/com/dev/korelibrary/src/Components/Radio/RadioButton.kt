package com.dev.korelibrary.src.Components.Radio

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.disableHotReloadMode
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Radio.RadioButtonDefaults.radioColor
import com.dev.korelibrary.src.Components.Switchs.SwitchDefaults
import com.dev.korelibrary.src.Components.Themes.KoreTheme
import com.dev.korelibrary.src.Components.Themes.Ripple.koreRipple

@Composable
fun RadioButton(
    selected : Boolean,
    modifier: Modifier = Modifier,
    onClick : (()-> Unit)?,
    enabled : Boolean,
    colors: RadioButtonColors= RadioButtonDefaults.defaultRadioColors(),
    interactionSource: MutableInteractionSource? = null
) {

    val dotRadius by animateDpAsState(
        targetValue = if (selected)
            RadioButtonDefaults.defaultRadioDotSize / 2
        else 0.dp
    )

    val dotColor = colors.radioColor(
        enabled = enabled,
        selected = selected
    )

    val selectableModifier =
        if (onClick != null) {
            Modifier.selectable(
                selected = selected,
                enabled = enabled,
                role = Role.RadioButton,
                interactionSource = interactionSource,
             //   indication = LocalIndication.current,
                onClick = onClick
            )
        } else Modifier

    Canvas(
        modifier = modifier
            .clip(CircleShape)
            .then(selectableModifier)
            .padding(RadioButtonDefaults.defaultRadioButtonPadding)
            .size(RadioButtonDefaults.defaultIconSize)
    ) {

        val strokeWidth = 2.dp.toPx()

        drawCircle(
            color = dotColor,
            style = Stroke(strokeWidth)
        )

        if (dotRadius > 0.dp) {
            drawCircle(
                color = dotColor,
                radius = dotRadius.toPx()
            )
        }
    }


}














object RadioButtonDefaults{

    @Composable
    fun defaultRadioColors(
        selectedColor: Color = KoreTheme.colorScheme.primary,
        unSelectedColor: Color = KoreTheme.colorScheme.primary,
        disabledSelectedColor: Color = KoreTheme.colorScheme.disabled,
        disabledUnSelectedColor: Color = KoreTheme.colorScheme.onDisabled
    )= RadioButtonColors(
        selectedColor = selectedColor,
        unSelectedColor = unSelectedColor,
        disabledSelectedColor = disabledSelectedColor,
        disabledUnSelectedColor = disabledUnSelectedColor
    )

    fun RadioButtonColors.radioColor(
        enabled: Boolean,
        selected: Boolean
    ): Color{
       return if (enabled) if (selected) this.selectedColor else this.unSelectedColor
        else if (selected) this.disabledSelectedColor else this.disabledUnSelectedColor
    }

    val defaultRadioDotSize = 12.dp

    val defaultRadioButtonPadding = 6.dp

    val defaultIconSize = 20.dp
}










@Immutable
data class RadioButtonColors(
    val selectedColor : Color,
    val unSelectedColor : Color,
    val disabledSelectedColor : Color,
    val disabledUnSelectedColor : Color
)