package com.example.typesofmenus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewExample extends AppCompatActivity {
EditText urledit;
Button openbtn,ropentbtn;
WebView webView;
String urls = "https://www.google.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_example);
        connextml();


     webView.setWebViewClient(new WebViewclcient());

        webView.loadUrl(urls);
        openbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urltext = urledit.getText().toString().trim();
                String urlse = "https://"+urltext+"/";
                webView.loadUrl(urlse);

                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setLoadsImagesAutomatically(true);

               urledit.setText(" ");
                urledit.setVisibility(View.GONE);
                openbtn.setVisibility(View.GONE);
                ropentbtn.setVisibility(View.VISIBLE);
            }
        });
  ropentbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          urledit.setVisibility(View.VISIBLE);
          openbtn.setVisibility(View.VISIBLE);
          ropentbtn.setVisibility(View.GONE);
      }
  });

    }

    private void connextml()
    {
        urledit = findViewById(R.id.urledit);
        openbtn = findViewById(R.id.open);
        ropentbtn = findViewById(R.id.reopen);
        webView = findViewById(R.id.webview);
    }

    class WebViewclcient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return true;
        }


    }
}