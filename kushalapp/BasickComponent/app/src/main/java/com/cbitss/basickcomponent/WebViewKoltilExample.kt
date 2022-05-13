package com.cbitss.basickcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class WebViewKoltilExample : AppCompatActivity() {
    lateinit var webviewcomponent:WebView
    lateinit var urlbtn:Button
    lateinit var urledit:EditText
    var urlSTring = "https://www.javatpoint.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_koltil_example)
        webviewcomponent = findViewById(R.id.webviw)
        urlbtn = findViewById(R.id.submiturl)
        urledit = findViewById(R.id.urledit)

        urlbtn.setOnClickListener {
            var urltext = urledit.text.toString()
            var finalurl = "https://$urltext/"
            webviewcomponent.loadUrl(finalurl)
        }
        webviewcomponent.loadUrl(urlSTring)

        var obj = MyWebViewClient()
        webviewcomponent.webViewClient = obj


    }
    private class MyWebViewClient :WebViewClient(){

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view!!.loadUrl(url!!)
            return true
        }
    }
}