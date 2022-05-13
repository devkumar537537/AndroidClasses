package com.example.basiccompoinenet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
WebView mywebview;
String urls = "https://www.google.com/";
String yahourrl = "https://login.yahoo.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mywebview = findViewById(R.id.webivew);

        MywebViewClient mywebViewClient =new MywebViewClient();
        mywebview.setWebViewClient(mywebViewClient);
       mywebview.loadUrl(urls         );
    }

    private class MywebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            mywebview.loadUrl(url);
            return true;
        }
    }
}