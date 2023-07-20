package com.example.textwithtagexample

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import com.example.textwithtagexample.ui.theme.TextWithTagExampleTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextWithTagExampleTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { paddingsValue ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingsValue),
                        contentAlignment = Alignment.Center
                    ) {
                        Greeting(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val text: String = context.getString(R.string.tagged_text)
    val styledText = Html.fromHtml(text, FROM_HTML_MODE_COMPACT)
    AndroidView(
        factory = {

            TextView(it).apply {
//                setText(styledText)
                setText(R.string.tagged_text)
                movementMethod = LinkMovementMethod.getInstance()
            }
        },
        modifier = modifier.background(Color.White)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextWithTagExampleTheme {
        Greeting()
    }
}