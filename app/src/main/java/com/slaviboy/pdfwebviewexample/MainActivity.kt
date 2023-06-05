package com.slaviboy.pdfwebviewexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.slaviboy.pdfwebview.PdfWebViewComposable

class MainActivity : ComponentActivity() {

    private val baseUrl = "https://raw.githubusercontent.com/slaviboy/RepositoryImages/main/pdf/"
    private var pdfFileNames = listOf(
        "RLAAG.pdf",
        "pdf_B450.pdf",
        "small_pdf_example.pdf"
    )
    private val randomPdfUrl: String
        get() = "${baseUrl}${pdfFileNames.random()}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var url by remember {
                mutableStateOf(randomPdfUrl)
            }
            PdfWebViewComposable(
                modifier = Modifier
                    .fillMaxSize(),
                url = url
            )
            Button(
                onClick = {
                    url = randomPdfUrl
                }
            ) {
                Text(text = "Change PDF file")
            }
        }
    }
}