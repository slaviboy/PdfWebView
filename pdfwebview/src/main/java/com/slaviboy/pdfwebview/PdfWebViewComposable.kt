package com.slaviboy.pdfwebview

import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun PdfWebViewComposable(
    modifier: Modifier,
    url: String?,
    webViewClient: WebViewClient? = null
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            PdfWebView(context).also { pdfWebView ->
                pdfWebView.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                )
                webViewClient?.let {
                    pdfWebView.webViewClient = it
                }
            }
        },
        update = { pdfWebView ->
            url?.let {
                pdfWebView.loadPdfUrl(it)
            }
        }
    )
}