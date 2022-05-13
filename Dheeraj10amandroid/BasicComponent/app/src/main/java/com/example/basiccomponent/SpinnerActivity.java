package com.example.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {
Spinner spinner;
TextView textView;
Button slelectbtn;
    String text;
    WebView webView;
    String urls = "https://www.google.com/";
String[] foodlist={"Select any food","Burger","Noodle","Samosa","flitters","pani puri","channe butre","Burger","Noodle","Samosa","flitters","pani puri","channe butre","Burger","Noodle","Samosa","flitters","pani puri","channe butre"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
 spinnelayout();
webView =findViewById(R.id.webview);
webView.loadUrl(urls);
MyWebviewCliet obj =new MyWebviewCliet();
webView.setWebViewClient(obj);
webView.getSettings().setJavaScriptEnabled(true);
webView.getSettings().setLoadsImagesAutomatically(true);
    }
    public void spinnelayout()
    {
        spinner = findViewById(R.id.spinerfooditems);
        textView =findViewById(R.id.fooditemtext);
        slelectbtn =findViewById(R.id.selectbtn);

        ArrayAdapter<String> foodadapter=new ArrayAdapter<String>(SpinnerActivity.this,R.layout.listviewformate,foodlist);
        foodadapter.setDropDownViewResource(R.layout.listviewformate);
        spinner.setAdapter(foodadapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                text = foodlist[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        slelectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(text);
            }
        });
    }

    private class MyWebviewCliet extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}