package com.dev.kore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Buttons.Icon
import com.dev.korelibrary.src.Components.Buttons.OutlinedButton
import com.dev.korelibrary.src.Components.Buttons.PrimaryButton
import com.dev.korelibrary.src.Components.Dialogs.AlertDialog
import com.dev.korelibrary.src.Components.Scaffold.Scaffold
import com.dev.korelibrary.src.Components.Text
import com.dev.korelibrary.src.Components.TextFields.OutlinedTextField
import com.dev.korelibrary.src.Components.TextFields.TextFieldDefaults
import com.dev.korelibrary.src.Components.Themes.KoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var enabled by rememberSaveable() { mutableStateOf(false) }
          var emailText by rememberSaveable() {mutableStateOf("") }
            KoreTheme{
                Scaffold(
                    content = {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(
                                    it

                                )
                        ) {

                            if (enabled){
                                AlertDialog(
                                    onDismissRequest = {
                                        enabled = false
                                    },
                                    title = {
                                        Text(
                                            text = "Are you sure you want to delete this item?"
                                        )
                                    },
                                    description = {
                                        Text(
                                            text = "Deleting this item will permanently remove all its details and associated item data. This action cannot be undone."
                                        )
                                    },
                                    confirmButton = {
                                        PrimaryButton(
                                            onClick = {
                                                enabled = false
                                            }
                                        ) {
                                            Text(
                                                text = "Cancel"
                                            )
                                        }
                                    },
                                    dismissButton = {
                                        OutlinedButton(
                                            onClick = {
                                                enabled = false
                                            }
                                        ) {
                                            Text(
                                                text = "Delete"
                                            )
                                        }
                                    }
                                )
                            }


                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth().padding(
                                    horizontal = 16.dp
                                ),

                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Rounded.Email,
                                        contentDescription = ""
                                    )
                                },
                                value =emailText,
                                onValueChange = {
                                    emailText = it
                                },
                                label = "enter mail"
                            )








//
                        }
                    }
                )
            }
        }
    }
}


@Preview
@Composable
private fun testButton() {
    OutlinedButton(
        onClick = {}
    ) {
        Text(
            text = "afk"
        )
    }
}