package com.example.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebVIewExample extends AppCompatActivity {
WebView webView;
String urls = "https://www.google.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_example);
        webView = findViewById(R.id.webviewexample);
        webView.loadUrl(urls);
       webView.setWebViewClient(new MyWebViewClient());
       webView.getSettings().setJavaScriptEnabled(true);
       webView.getSettings().getLoadsImagesAutomatically();

    }

    class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}