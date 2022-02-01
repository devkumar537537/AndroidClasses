package com.example.advanceviewview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
WebView webView;
String url ="https://www.javatpoint.com/";
EditText urledit;
Button openurlbtn,backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectxml();


MyWevViewcline myWevViewcline = new MyWevViewcline();
        webView.setWebViewClient(myWevViewcline);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        openurlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String urltext = urledit.getText().toString().trim();
                String fialtext = "https://"+urltext+"/";
                webView.loadUrl(fialtext);
                urledit.setVisibility(View.GONE);
                openurlbtn.setVisibility(View.GONE);
                backbtn.setVisibility(View.VISIBLE);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urledit.setVisibility(View.VISIBLE);
                openurlbtn.setVisibility(View.VISIBLE);
                backbtn.setVisibility(View.GONE);
            }
        });
    }

    private void connectxml()
    {
        urledit = findViewById(R.id.openedit);
        openurlbtn = findViewById(R.id.openur);
        backbtn = findViewById(R.id.back);
        webView = findViewById(R.id.webview);
    }

    class  MyWevViewcline extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return true;
        }
    }
}