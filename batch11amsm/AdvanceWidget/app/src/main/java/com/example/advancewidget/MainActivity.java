package com.example.advancewidget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
WebView webView;
String urls = "https://www.google.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);
        webView.loadUrl(urls);
        webView.setWebViewClient(new MyWevViewClient());


        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().getLoadsImagesAutomatically();

    }

    class MyWevViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return true;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.firstoption)
        {
          sum(4,5);
        }else if(id == R.id.secondoption)
        {
            mult(4,5);
        }
        return super.onOptionsItemSelected(item);
    }

    public void sum(int a,int b)
    {
        Toast.makeText(this, "sum is "+(a+b), Toast.LENGTH_SHORT).show();
    }

    public void mult(int a,int b)
    {
        Toast.makeText(this, "multi is "+(a*b), Toast.LENGTH_SHORT).show();
    }
}