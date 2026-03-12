package com.dev.korelibrary.src.Components.Dialogs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.dev.korelibrary.src.Components.Buttons.OutlinedButton
import com.dev.korelibrary.src.Components.Buttons.PrimaryButton
import com.dev.korelibrary.src.Components.Buttons.SecondaryButton
import com.dev.korelibrary.src.Components.Text
import com.dev.korelibrary.src.Components.Themes.KoreColors
import com.dev.korelibrary.src.Components.Themes.KoreDefaults
import com.dev.korelibrary.src.Components.Themes.KoreTheme
import com.dev.korelibrary.src.Components.Themes.LocalTextStyle
import com.dev.korelibrary.src.Components.Themes.TailwindColors

@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    title : @Composable () -> Unit,
    description : @Composable () -> Unit = {},
    dialogShape : Shape = DialogDefaults.defaultDialogShape,
    dialogColors: DialogColors = DialogDefaults.alertDialogColors(),
    dismissButton : @Composable () -> Unit ={},
    confirmButton : @Composable () -> Unit ={},
    dialogProperties: DialogProperties = DialogDefaults.defaultDialogProperties,
    dialogPadding : PaddingValues = DialogDefaults.defaultDialogPaddingValues
) {
    Dialog(
        onDismissRequest = {
            onDismissRequest.invoke()
        },
        properties = dialogProperties
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .shadow(8.dp, dialogShape)
                .background(
                    color = dialogColors.containerColor,
                    shape = dialogShape
                )
                .padding(
                    paddingValues = dialogPadding
                )
        ) {
            Column() {
                // top heading
                CompositionLocalProvider(
                    LocalTextStyle provides KoreTheme.typography.titleLarge.copy(
                        color = dialogColors.titleTextColor
                    )
                ){
                    title()
                }
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
                // middle part for explaining the intent
               CompositionLocalProvider(
                   LocalTextStyle provides KoreTheme.typography.titleSmall.copy(
                       color = dialogColors.descriptionTextColor
                   )
               ) {
                   description()
               }

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                // row for actions
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    //less likely task
                   dismissButton.let {
                       dismissButton()
                       Spacer(
                           modifier = Modifier.width(8.dp)
                       )
                   }
                    // primary task y wanna execute
                    confirmButton()



                }

            }
        }
    }
}

object DialogDefaults{

    val defaultDialogShape : Shape
        @Composable get() = KoreTheme.shapes.large
    val defaultDialogPaddingValues : PaddingValues = PaddingValues(24.dp)

    val defaultDialogProperties : DialogProperties = DialogProperties(
        usePlatformDefaultWidth = true,
        dismissOnBackPress = true,
        dismissOnClickOutside = true
    )




    @Composable
    fun alertDialogColors(
        containerColor: Color = KoreTheme.colorScheme.background,
        titleTextColors: Color = KoreTheme.colorScheme.onBackGround,
        descriptionTextColor: Color = KoreTheme.colorScheme.onBackGroundVariant,
        borderColor: Color = KoreTheme.colorScheme.backGroundVariant
    ) = DialogColors(
        containerColor = containerColor,
        titleTextColor = titleTextColors,
        descriptionTextColor = descriptionTextColor,
        borderColor = borderColor
    )

}


@Immutable
data class DialogColors(
    val containerColor : Color,
    val titleTextColor : Color,
    val descriptionTextColor : Color,
    val borderColor : Color
)





@Preview
@Composable
fun TestDialog() {
        Dialog(
            onDismissRequest = {},
            properties = DialogProperties(
                usePlatformDefaultWidth = true
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = KoreTheme.colorScheme.background,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(
                        16.dp
                    )
            ) {
                Column() {
                    Text(
                        text = "Are you sure ?",
                    )
                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                    Text(
                        textStyle = KoreTheme.typography.titleSmall,
                        text = "lorem ipsumaiofa opapojf[joa[pfjapofjallmlmlmll"
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Spacer(
                            modifier = Modifier.weight(1f)
                        )
                        SecondaryButton(
                            onClick = {}
                        ) {
                            Text(
                                text = "Cancel"
                            )
                        }
                        PrimaryButton(
                            onClick = {}
                        ) {
                            Text(
                                text = "Confirm"
                            )
                        }



                    }

                }
            }
        }


}