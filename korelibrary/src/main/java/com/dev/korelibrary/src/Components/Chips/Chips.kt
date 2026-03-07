package com.dev.korelibrary.src.Components.Chips

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Chips.ChipDefaults.containerColor
import com.dev.korelibrary.src.Components.Chips.ChipDefaults.contentColor
import com.dev.korelibrary.src.Components.Themes.KoreTheme
import com.dev.korelibrary.src.Components.Themes.LocalContentColor
import com.dev.korelibrary.src.Components.Themes.LocalTextStyle
import io.jadu.nivi.presentation.utils.squircleShape.CornerSmoothing
import io.jadu.nivi.presentation.utils.squircleShape.SquircleShape


@Composable
internal fun BaseChip(
    content : @Composable ()-> Unit,
    modifier: Modifier = Modifier,
    shape : Shape = ChipDefaults.defaultChipShape,
    chipSizes: ChipSizes = ChipDefaults.defaultChipSize(),
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    border : BorderStroke ? = null,
    enabled : Boolean = true,
    chipColors: ChipColors
) {
    CompositionLocalProvider(
        values = arrayOf(
            LocalContentColor provides chipColors.contentColor(enabled = enabled),
            LocalTextStyle provides KoreTheme.typography.labelMedium
        )
    ) {
        Box(
            modifier = modifier
                .background(
                    shape = shape, color = chipColors.containerColor(enabled = enabled)
                )
                .then(
                    if (border != null) Modifier.border(
                        border = border,
                        shape = shape
                    ) else Modifier
                )
        ) {
            Row(
                modifier = Modifier.padding(
                   chipSizes.containerPadding
                )
                ,verticalAlignment = Alignment.CenterVertically
            ) {
              leadingIcon?.let {
                  Box(
                      modifier = Modifier
                          .size(chipSizes.leadingIconSize)
                  ){
                      leadingIcon()
                  }
              }

                Box(
                    modifier = modifier.padding(
                     chipSizes.contentPadding
                    )
                ){
                    content()
                }

                trailingIcon?.let {
                    Box(
                        modifier = Modifier
                            .size(chipSizes.trailingIconSize)
                    ) {
                        trailingIcon()
                    }
                }
            }
        }
    }
}




// primary chip will be used for the primary actions

@Composable
fun PrimaryChip(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = ChipDefaults.defaultChipShape,
    chipSizes: ChipSizes = ChipDefaults.defaultChipSize(),
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    chipColors: ChipColors = ChipDefaults.primaryChipColors()
) {
    BaseChip(
        content = content,
        modifier = modifier,
        shape = shape,
        chipSizes = chipSizes,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        chipColors = chipColors
    )
}


@Composable
fun SuccessChip(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = ChipDefaults.defaultChipShape,
    chipSizes: ChipSizes = ChipDefaults.defaultChipSize(),
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    chipColors: ChipColors = ChipDefaults.successChipColors()
) {
    BaseChip(
        content = content,
        modifier = modifier,
        shape = shape,
        chipSizes = chipSizes,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        chipColors = chipColors
    )
}


@Composable
fun ErrorChip(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = ChipDefaults.defaultChipShape,
    chipSizes: ChipSizes = ChipDefaults.defaultChipSize(),
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    chipColors: ChipColors = ChipDefaults.errorChipColors()
) {
    BaseChip(
        content = content,
        modifier = modifier,
        shape = shape,
        chipSizes = chipSizes,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        chipColors = chipColors
    )
}

@Composable
fun SecondaryChip(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = ChipDefaults.defaultChipShape,
    chipSizes: ChipSizes = ChipDefaults.defaultChipSize(),
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    chipColors: ChipColors = ChipDefaults.secondaryChipColors()
) {
    BaseChip(
        content = content,
        modifier = modifier,
        shape = shape,
        chipSizes = chipSizes,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        chipColors = chipColors
    )
}

@Composable
fun OutlinedChip(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = ChipDefaults.defaultChipShape,
    chipSizes: ChipSizes = ChipDefaults.defaultChipSize(),
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    chipColors: ChipColors = ChipDefaults.outlinedChipColor()
) {
    BaseChip(
        content = content,
        modifier = modifier,
        shape = shape,
        chipSizes = chipSizes,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = if (enabled) chipColors.contentColor else chipColors.disabledContentColor
        ),
        enabled = enabled,
        chipColors = chipColors
    )
}






object ChipDefaults {

  @Composable
  fun defaultChipSize (
      leadingIconSize: Dp = defaultLeadingIconSize,
      leadingIconPadding: PaddingValues = PaddingValues(0.dp),
      trailingIconSize: Dp = defaultTrailingIconSize,
      trailingIconPadding: PaddingValues = PaddingValues(0.dp) ,
      contentPadding : PaddingValues = horizontalContentPadding,
      containerPadding : PaddingValues = PaddingValues(vertical = 2.dp, horizontal = 6.dp)
  )
  = ChipSizes(
      leadingIconSize = leadingIconSize,
      leadingIconPadding = leadingIconPadding,
      trailingIconSize = trailingIconSize,
      trailingIconPadding = trailingIconPadding,
      contentPadding = contentPadding,
      containerPadding = containerPadding
  )


    @Composable
    fun primaryChipColors(
        containerColor: Color = KoreTheme.colorScheme.primary,
        contentColor: Color = KoreTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
        leadingContentColor: Color = KoreTheme.colorScheme.onPrimary,
        disabledLeadingContentColor: Color = KoreTheme.colorScheme.onDisabled,
        trailingContentColor: Color = KoreTheme.colorScheme.onPrimary,
        disabledTrailingContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ChipColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        leadingContentColor = leadingContentColor,
        disabledLeadingContentColor = disabledLeadingContentColor,
        trailingContentColor = trailingContentColor,
        disabledTrailingContentColor = disabledTrailingContentColor
    )

    @Composable
    fun secondaryChipColors(
        containerColor: Color = KoreTheme.colorScheme.backGroundVariant,
        contentColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
        leadingContentColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        disabledLeadingContentColor: Color = KoreTheme.colorScheme.onDisabled,
        trailingContentColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        disabledTrailingContentColor: Color = KoreTheme.colorScheme.onDisabled
    )  =
        ChipColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
            leadingContentColor = leadingContentColor,
            disabledLeadingContentColor = disabledLeadingContentColor,
            trailingContentColor = trailingContentColor,
            disabledTrailingContentColor = disabledTrailingContentColor,
        )

    @Composable
    fun outlinedChipColor(
        containerColor: Color = KoreTheme.colorScheme.primary.copy(alpha = 0.1f),
        contentColor: Color = KoreTheme.colorScheme.primary,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
        leadingContentColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        disabledLeadingContentColor: Color = KoreTheme.colorScheme.onDisabled,
        trailingContentColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        disabledTrailingContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ChipColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        leadingContentColor = leadingContentColor,
        disabledLeadingContentColor = disabledLeadingContentColor,
        trailingContentColor = trailingContentColor,
        disabledTrailingContentColor = disabledTrailingContentColor
    )

    @Composable
    fun successChipColors(
        containerColor: Color = KoreTheme.colorScheme.success,
        contentColor: Color = KoreTheme.colorScheme.onSuccess,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
        leadingContentColor: Color = KoreTheme.colorScheme.onSuccess,
        disabledLeadingContentColor: Color = KoreTheme.colorScheme.onDisabled,
        trailingContentColor: Color = KoreTheme.colorScheme.onSuccess,
        disabledTrailingContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ChipColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        leadingContentColor = leadingContentColor,
        disabledLeadingContentColor = disabledLeadingContentColor,
        trailingContentColor = trailingContentColor,
        disabledTrailingContentColor = disabledTrailingContentColor
    )

    @Composable
    fun errorChipColors(
        containerColor: Color = KoreTheme.colorScheme.error,
        contentColor: Color = KoreTheme.colorScheme.onError,
        disabledContainerColor: Color = KoreTheme.colorScheme.disabled,
        disabledContentColor: Color = KoreTheme.colorScheme.onDisabled,
        leadingContentColor: Color = KoreTheme.colorScheme.onError,
        disabledLeadingContentColor: Color = KoreTheme.colorScheme.onDisabled,
        trailingContentColor: Color = KoreTheme.colorScheme.onError,
        disabledTrailingContentColor: Color = KoreTheme.colorScheme.onDisabled
    ) = ChipColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        leadingContentColor = leadingContentColor,
        disabledLeadingContentColor = disabledLeadingContentColor,
        trailingContentColor = trailingContentColor,
        disabledTrailingContentColor = disabledTrailingContentColor
    )

   // the default size for the chip
    val defaultChipShape = SquircleShape(90.dp, cornerSmoothing = CornerSmoothing.Small)




    val horizontalContentPadding = PaddingValues(
        horizontal = 4.dp
    )
    val defaultLeadingIconSize = 18.dp

    val defaultTrailingIconSize = 18.dp


    internal fun ChipColors.contentColor (
       enabled : Boolean
    ) : Color{
       return if (enabled) contentColor else disabledContentColor
    }


    internal fun ChipColors.containerColor(
        enabled: Boolean
    ) : Color{
        return if (enabled) containerColor else disabledContainerColor
    }


}


data class ChipColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor : Color,
    val disabledContentColor : Color,
    val leadingContentColor : Color,
    val disabledLeadingContentColor : Color,
    val trailingContentColor : Color,
    val disabledTrailingContentColor : Color
)

data class ChipSizes(
    val leadingIconSize : Dp = Dp.Unspecified,
    val leadingIconPadding : PaddingValues,
    val trailingIconSize : Dp = Dp.Unspecified,
    val trailingIconPadding : PaddingValues,
    val contentPadding : PaddingValues,
    val containerPadding : PaddingValues,
)