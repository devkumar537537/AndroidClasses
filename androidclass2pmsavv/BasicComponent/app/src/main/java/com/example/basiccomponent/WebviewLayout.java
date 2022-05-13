package com.example.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebviewLayout extends AppCompatActivity {
WebView mywebview;
String url = "https://www.google.com/";
EditText editurl;
Button openurlbtn,openshowurlbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_layout);
        mywebview = findViewById(R.id.mywebview);
        editurl = findViewById(R.id.urledit);
        openurlbtn = findViewById(R.id.openurlbtn);
        openshowurlbtn = findViewById(R.id.openviewbtn);
        openshowurlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openurlbtn.setVisibility(View.VISIBLE);
                editurl.setVisibility(View.VISIBLE);
                openshowurlbtn.setVisibility(View.GONE);
            }
        });
        MyWebViewClient myWebViewClient = new MyWebViewClient();
        mywebview.setWebViewClient(myWebViewClient);
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.getSettings().setLoadsImagesAutomatically(true);
         mywebview.loadUrl(url);
openurlbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String urltext = editurl.getText().toString();
        String finalurl = "https://"+urltext+"/";
        mywebview.loadUrl(finalurl);
        openurlbtn.setVisibility(View.GONE);
        editurl.setVisibility(View.GONE);
        openshowurlbtn.setVisibility(View.VISIBLE);
    }
});
    }
    private class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            mywebview.loadUrl(url);
            return true;
        }
    }
}