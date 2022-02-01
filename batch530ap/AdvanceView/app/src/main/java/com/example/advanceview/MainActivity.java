package com.example.advanceview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    String weburl = "https://www.google.com/";

    Spinner spinner;
    Button submitbtn;
    String selectedurl;

    String[] urlist = {"www.google.com","www.facebook.com","www.youtube.com","www.javatpoint.com","www.tutorialspoint.com","www.GreekforGreeks"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);
submitbtn =findViewById(R.id.submiturl);
spinner = findViewById(R.id.spinner);
        MyWebviewClient mone = new MyWebviewClient();
        webView.setWebViewClient(mone);
        webView.loadUrl(weburl);


        //spinnerlsit

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinnerlayout,urlist);
        arrayAdapter.setDropDownViewResource(R.layout.spinnerlayout);


        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selectedurl = urlist[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String withrul = "https://"+selectedurl+"/";
                webView.loadUrl(withrul);
            }
        });
    }


    private class MyWebviewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return true;
        }
    }
}