package com.dev.kore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Buttons.ButtonDefaults
import com.dev.korelibrary.src.Components.Buttons.Icon
import com.dev.korelibrary.src.Components.Buttons.OutlinedButton
import com.dev.korelibrary.src.Components.Buttons.PrimaryButton
import com.dev.korelibrary.src.Components.Buttons.SecondaryButton
import com.dev.korelibrary.src.Components.Chips.ErrorChip
import com.dev.korelibrary.src.Components.Chips.PrimaryChip
import com.dev.korelibrary.src.Components.Chips.SuccessChip
import com.dev.korelibrary.src.Components.Dialogs.AlertDialog
import com.dev.korelibrary.src.Components.Radio.RadioButton
import com.dev.korelibrary.src.Components.Scaffold.Scaffold
import com.dev.korelibrary.src.Components.Switchs.Switch
import com.dev.korelibrary.src.Components.Switchs.SwitchDefaults
import com.dev.korelibrary.src.Components.Text
import com.dev.korelibrary.src.Components.TextFields.OutlinedTextField
import com.dev.korelibrary.src.Components.TextFields.TextFieldDefaults
import com.dev.korelibrary.src.Components.Themes.KoreColors
import com.dev.korelibrary.src.Components.Themes.KoreTheme
import com.dev.korelibrary.src.Components.Themes.RadixColors
import com.dev.korelibrary.src.Components.Themes.TailwindColors
import io.jadu.nivi.presentation.utils.squircleShape.CornerSmoothing
import io.jadu.nivi.presentation.utils.squircleShape.SquircleBasedShape
import io.jadu.nivi.presentation.utils.squircleShape.SquircleShape

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            KoreTheme{
KoreExample()
            }
        }
    }
}


@Preview
@Composable
private fun KoreExample() {
    var enabledSw by rememberSaveable() { mutableStateOf(false) }
    var enabled by rememberSaveable() { mutableStateOf(false) }
    var switch by rememberSaveable() {mutableStateOf(false) }
    var showDialog by rememberSaveable() {mutableStateOf(false) }

    if (showDialog){
        AlertDialog(
            onDismissRequest = {
                showDialog= false
            },
            confirmButton = {
                PrimaryButton(
                    onClick = {}
                ) {
                    Text("Don't")
                }
            },
            description = {
                Text("Hello dev iam afhapfn apfhpa aofhpajf oiafpaofo pafphfpa ahfnopafp pajfpoaj ffopf pao fahop ")
            },
            title = {
                Text("Are you sure ?")
            },
            dismissButton = {
                SecondaryButton(
                    onClick = {}
                ) {
                    Text("Done")
                }
            }
        )
    }
    Scaffold(
        content = {

            FlowColumn(
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxSize()

                    .padding(
                        it

                    ).padding(
                        horizontal = 16.dp
                    )
            ) {

              Text(
                  text = "This is the Example text "
              )

               Switch(
                   switchColors = SwitchDefaults.defaultSwitchColors(
                       unCheckedTrackColor = RadixColors.Blue.Dark.step3
                   ),
                   enabled = true,
                   checked = switch,
                   onCheckChange = {
                       switch = it
                   }
               )

                FlowRow(
                    modifier = Modifier.padding(
                        vertical = 8.dp,
                        horizontal = 16.dp
                    ),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    SuccessChip(
                        content = {
                            Text("Success")
                        }
                    )


                    ErrorChip(
                        content = {
                            Text("Error")
                        }
                    )
                }

                PrimaryButton(
                    onClick = {
                        showDialog = true
                    }
                ) {
                    Text("Secondary Dev")
                }
                SecondaryButton(
                    onClick = {

                    }
                ){
                    Text(
                        text = "Secondary Button"
                    )
                }
                PrimaryButton(

                    //enabled = false,
                    onClick = {
                        enabled = !enabled
                    }
                ) {
                    Text("Hello Dev")
                }

                Spacer(
                    modifier = Modifier.height(18.dp)
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 0.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Dark Theme",
                    )
                    Spacer(
                        modifier = Modifier.weight(1f)
                    )
                    RadioButton(
                        selected = enabledSw,
                        onClick = {
                            enabledSw = !enabledSw
                        },
                        enabled = enabled
                    )
                }
            }
        }
    )
}



