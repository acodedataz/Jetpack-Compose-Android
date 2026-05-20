package com.shanto.learnjeetpackcompose.`3_CoreComponents`


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PartiallySelectedText() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        SelectionContainer {
            Column {
                Text("This is a Text Can be Select")
                Text("This is The Second Text")
                Text("This is The Third Text")
                DisableSelection {
                    Text("This is Not Selectable One")
                    Text("This is Not Selectable Text")
                }
            }
        }
    }
}

// Annotated String Text Linked
@Composable
fun AnnotatedStringWithListenerSimple() {
    val uriHandler = LocalUriHandler.current
    
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            buildAnnotatedString {
                append("Build Faster App With ")
                val link = LinkAnnotation.Url(
                    "https://www.nu.ac.bd/recent-news-notice.php",
                    TextLinkStyles(
                        SpanStyle(
                            color = Color.Blue
                        )
                    )
                ) {
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)
                }
                withLink(link) {
                    append("Jetpack Compose")
                }
            })
    }

}

// Preview Showing in Display
@Preview(showSystemUi = true)
@Composable
fun MyPreview() {
    AnnotatedStringWithListenerSimple()
}