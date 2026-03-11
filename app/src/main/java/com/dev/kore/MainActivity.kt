package com.dev.kore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.dev.korelibrary.src.Components.Buttons.Icon
import com.dev.korelibrary.src.Components.Scaffold.Scaffold
import com.dev.korelibrary.src.Components.Text
import com.dev.korelibrary.src.Components.Themes.KoreTheme
import icons.PhIcons
import icons.duotone.BedDuotone
import icons.duotone.CaretDownDuotone
import icons.duotone.CodeDuotone
import icons.duotone.CodepenLogoDuotone
import icons.duotone.FigmaLogoDuotone

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
    var expandedAccordion by rememberSaveable() {mutableStateOf(false) }
    var expanded2 by rememberSaveable() {mutableStateOf(false) }
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

           Accordion(
               separator = false,
               expanded = accordion1,
               header = {
                   Text("What is Jetpack Compose?")
               },
               icon = {
                   Icon(
                       imageVector = PhIcons.Duotone.CaretDownDuotone,
                       contentDescription = ""
                   )
               },
               expandedContent = {
                   Text("Jetpack Compose is Android's modern toolkit for building native UI with Kotlin.")
               },
               leadingIcon = {
                   Icon(
                       imageVector = PhIcons.Duotone.CodepenLogoDuotone,
                       contentDescription = null
                   )
               },
               onExpand = {
                   accordion1 = !accordion1
               }
           )

           Accordion(
               expanded = accordion2,
               header = {
                   Text("What is a Design System?")
               },
               icon = {
                   Icon(
                       imageVector = PhIcons.Duotone.CaretDownDuotone,
                       contentDescription = ""
                   )
               },
               expandedContent = {
                   Text("A design system contains reusable UI components and guidelines.")
               },
               leadingIcon = {
                   Icon(
                       imageVector = PhIcons.Duotone.FigmaLogoDuotone,
                       contentDescription = null
                   )
               },
               onExpand = {
                   accordion2 = !accordion2
               }
           )

           Accordion(
               expanded = accordion3,
               header = {
                   Text("Why use a design system?")
               },
               icon = {
                   Icon(
                       imageVector = PhIcons.Duotone.CaretDownDuotone,
                       contentDescription = ""
                   )
               },
               expandedContent = {
                   Text("It improves consistency, speed of development, and UI quality.")
               },
               leadingIcon = {
                   Icon(
                       imageVector = PhIcons.Duotone.CodeDuotone,
                       contentDescription = null
                   )
               },
               onExpand = {
                   accordion3 = !accordion3
               }
           )

       }
   }
}