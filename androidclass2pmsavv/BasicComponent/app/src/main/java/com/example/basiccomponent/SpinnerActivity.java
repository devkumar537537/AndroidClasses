package com.example.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {
    String websiteurl = "https://www.google.com/";
Spinner spinner;
    TextView textView;
    EditText urledit;
    Button slelectbtn;
    String selectedfooditem;
    WebView webView;
    ArrayList<String> arrayList =new ArrayList<>();
    String[] foodlist={"Select any food","Burger","Noodle","Samosa","flitters","pani puri","channe butre","Burger","Noodle","Samosa","flitters","pani puri","channe butre","Burger","Noodle","Samosa","flitters","pani puri","channe butre"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = findViewById(R.id.spinnerfooditems);
        textView =findViewById(R.id.fooditemtext);
        slelectbtn =findViewById(R.id.selectbtn);
        webView =findViewById(R.id.webview);
        urledit = findViewById(R.id.websiterurl);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SpinnerActivity.this,R.layout.spinnerlayout,foodlist);
        arrayAdapter.setDropDownViewResource(R.layout.spinnerlayout);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selectedfooditem = foodlist[position];
                arrayList.add(selectedfooditem);

                StringBuilder stringBuilder =new StringBuilder();
                for(String i : arrayList)
                {
                    stringBuilder.append(i+"\n");
                }
                textView.setText(stringBuilder);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        slelectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                arrayList.add(selectedfooditem);

                StringBuilder stringBuilder =new StringBuilder();
               for(String i : arrayList)
               {
                   stringBuilder.append(i+"\n");
               }
                textView.setText(stringBuilder);
                 String url = urledit.getText().toString();
             //   String url = "www.javatpoint.com";
                String finalurl = "https://"+url+"/";
                webView.loadUrl(finalurl);
            }
        });
        //webview code
        String url = "www.javatpoint.com";
        String finalurl = "https://"+url+"/";
        webView.loadUrl(finalurl);
        MyWebViewClient myWebViewClient =new MyWebViewClient();
        webView.setWebViewClient(myWebViewClient);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
    }


    public class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return true;
        }
    }
}