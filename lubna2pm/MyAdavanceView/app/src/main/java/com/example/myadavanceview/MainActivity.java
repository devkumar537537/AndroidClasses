package com.example.myadavanceview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
WebView webView;
EditText ediurl;
Button urlopen,previousgo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectxml();
        webView =findViewById(R.id.webiview);

MyWebviewclient mone = new MyWebviewclient();
webView.setWebViewClient(mone);
webView.getSettings().setJavaScriptEnabled(true);
webView.getSettings().setLoadsImagesAutomatically(true);

        urlopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urltext = ediurl.getText().toString();
                String finalurl= "https://"+urltext+"/";
                webView.loadUrl(finalurl);




               previousgo.setVisibility(View.VISIBLE);
               ediurl.setVisibility(View.GONE);
               urlopen.setVisibility(View.GONE);
            }
        });

        previousgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousgo.setVisibility(View.GONE);
                ediurl.setVisibility(View.VISIBLE);
                urlopen.setVisibility(View.VISIBLE);
            }
        });
    }

    private void connectxml() {
        ediurl = findViewById(R.id.urledit);
        urlopen = findViewById(R.id.openurl);
        previousgo = findViewById(R.id.previousbtn);
    }


    private class  MyWebviewclient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return true;
        }
    }





}