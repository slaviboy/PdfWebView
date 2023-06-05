package com.slaviboy.pdfwebview

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

class PdfWebView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : WebView(context, attrs) {

    private var pdfUrl: String? = null
    private var isPdfUrlLoaded: Boolean = false

    fun loadPdfUrl(url: String) {
        pdfUrl = url
        isPdfUrlLoaded = false
        if (isAttachedToWindow) {
            loadPdfUrl()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setInitSettings()
        loadPdfUrl()
    }

    private fun loadPdfUrl() {
        if (isPdfUrlLoaded) return
        pdfUrl?.let {
            loadUrl("$assetsBase$it")
        }
        isPdfUrlLoaded = true
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setInitSettings() {
        settings.javaScriptEnabled = true
        settings.allowFileAccessFromFileURLs = true
        settings.allowUniversalAccessFromFileURLs = true
    }

    companion object {
        private const val assetsBase = "file:///android_asset/mobile-viewer/viewer.html?url="
    }
}