package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText urledit;
Button openurlbtn,againopenurlbtn,movetoratingbar;
WebView webView;
String urlstring = "https://www.google.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connextxml();
        webView.loadUrl(urlstring);

        webView.setWebViewClient(new MyWebViewClient());

        openurlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urltext = urledit.getText().toString().trim();
                String combinedurl = "https://"+urltext+"/";
                webView.loadUrl(combinedurl);
                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setJavaScriptEnabled(true);
                againopenurlbtn.setVisibility(View.VISIBLE);
                urledit.setVisibility(View.GONE);
                openurlbtn.setVisibility(View.GONE);

            }
        });

        againopenurlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urledit.setVisibility(View.VISIBLE);
                openurlbtn.setVisibility(View.VISIBLE);
                againopenurlbtn.setVisibility(View.GONE);
            }
        });

        movetoratingbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RatingBarExample.class);
                startActivity(intent);
            }
        });
    }
    private void connextxml()
    {
        urledit = findViewById(R.id.editurl);
        openurlbtn = findViewById(R.id.openurl);
        againopenurlbtn = findViewById(R.id.openagainbtn);
        webView = findViewById(R.id.webivew);
        movetoratingbar = findViewById(R.id.movetoratingbar);

    }
    public class  MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return true;
        }
    }
}