package com.batch12pm.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
WebView webView;

EditText editurl;
Button btnopenurl,backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
webView = findViewById(R.id.webview);
editurl = findViewById(R.id.urledit);
btnopenurl = findViewById(R.id.openurlbtn);
backbtn = findViewById(R.id.backbtn);

backbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        editurl.setVisibility(View.VISIBLE);
        btnopenurl.setVisibility(View.VISIBLE);
        backbtn.setVisibility(View.GONE);
    }
});
btnopenurl.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String urltext = editurl.getText().toString();
        String finaltext = "https://"+urltext+"/";
        webView.loadUrl(finaltext);

        btnopenurl.setVisibility(View.GONE);
        editurl.setVisibility(View.GONE);
        backbtn.setVisibility(View.VISIBLE);
    }
});
MyWebviewclient myWebviewclient = new MyWebviewclient();
webView.setWebViewClient(myWebviewclient);
webView.getSettings().setJavaScriptEnabled(true);
webView.getSettings().setLoadsImagesAutomatically(true);



    }


    private class MyWebviewclient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return true;
        }
    }
}