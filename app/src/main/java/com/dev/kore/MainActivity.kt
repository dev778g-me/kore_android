package com.dev.kore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Accordion.Accordion
import com.dev.korelibrary.src.Components.Buttons.ButtonSizes
import com.dev.korelibrary.src.Components.Buttons.GhostIconButton
import com.dev.korelibrary.src.Components.Buttons.Icon
import com.dev.korelibrary.src.Components.Buttons.PrimaryButton
import com.dev.korelibrary.src.Components.Buttons.SecondaryButton
import com.dev.korelibrary.src.Components.Buttons.SecondaryIconButton
import com.dev.korelibrary.src.Components.Card.Card
import com.dev.korelibrary.src.Components.Card.OutlinedCard
import com.dev.korelibrary.src.Components.Scaffold.Scaffold
import com.dev.korelibrary.src.Components.Stack.VerticalStack
import com.dev.korelibrary.src.Components.Text
import com.dev.korelibrary.src.Components.Themes.KoreTheme
import icons.PhIcons
import icons.duotone.BedDuotone
import icons.duotone.CaretDownDuotone
import icons.duotone.CodeDuotone
import icons.duotone.CodepenLogoDuotone
import icons.duotone.FigmaLogoDuotone
import icons.regular.Code

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoreTheme {
               AccordCompo()
            }
        }
    }
}




@Preview(
    showBackground = true
)
@Composable
fun AccordCompo(modifier: Modifier = Modifier) {
    var expandedAccordion by rememberSaveable() { mutableStateOf(false) }
    var expanded2 by rememberSaveable() { mutableStateOf(false) }
    var accordion1 by remember { mutableStateOf(false) }
    var accordion2 by remember { mutableStateOf(false) }
    var accordion3 by remember { mutableStateOf(false) }


    Scaffold() {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    horizontal = 16.dp
                ),
            verticalArrangement = Arrangement.Center,
            //  horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedCard(

            ) {
                SecondaryButton(
                    onClick = {}
                ) {

                    Text("Hello")
                }




                Text(
                    // color = KoreTheme.colorScheme.primary,
                    text = "lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non pro"
                )
            }
            Spacer(
                modifier = modifier.height(24.dp)
            )
            Card(

            ) {
                SecondaryIconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = PhIcons.Duotone.FigmaLogoDuotone,
                        contentDescription = null
                    )
                }

                Text(
                    //color = KoreTheme.colorScheme.primary,
                    text = "lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non pro"
                )
            }

        }
    }
}