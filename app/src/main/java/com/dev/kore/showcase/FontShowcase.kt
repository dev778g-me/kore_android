package com.dev.kore.showcase

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.src.Components.Text
import com.dev.korelibrary.src.Components.Themes.KoreTheme

@Composable
fun FontShowcase(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "DisplayLarge",
            textStyle = KoreTheme.typography.displayLarge,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "DisplayMedium",
            textStyle = KoreTheme.typography.displayMedium,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "DisplaySmall",
            textStyle = KoreTheme.typography.displaySmall,
            modifier = Modifier.padding(vertical = 4.dp)
        )


        Text(
            text = "TitleLarge",
            textStyle = KoreTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "TitleMedium",
            textStyle = KoreTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "TitleSmall",
            textStyle = KoreTheme.typography.titleSmall,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "BodyLarge",
            textStyle = KoreTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "BodyMedium",
            textStyle = KoreTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "BodySmall",
            textStyle = KoreTheme.typography.bodySmall,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "LabelLarge",
            textStyle = KoreTheme.typography.labelLarge,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "LabelMedium",
            textStyle = KoreTheme.typography.labelMedium,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "LabelSmall",
            textStyle = KoreTheme.typography.labelSmall,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FontShowCasePrev() {
    KoreTheme{
        FontShowcase()
    }
}