package com.cbitss.anotherprojectrestapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UserDetail extends AppCompatActivity {
    EditText editname,editnumber,editid,editdate;
    Button updatebtn,deletebtn;

    Item item;
    ProgressBar detailProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        bindviews();
        getdata();
        updatviews();
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatedata();
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             deletedata();
            }
        });
    }

    private void deletedata() {
        String id_text = editid.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://script.google.com/macros/s/AKfycbyHXhUJuKtRc1zgXsQzeeliIMNmK83lGIkVKTNw1nuO3aMncvYXnGUtmARkL3ExDXtYQQ/exec?action=delete&id="+id_text,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        detailProgressBar.setVisibility(View.GONE);
                        Toast.makeText(UserDetail.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                detailProgressBar.setVisibility(View.GONE);
                Toast.makeText(UserDetail.this, "errror "+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        );

        int soketimeout= 50000;

        RetryPolicy retryPolicy = new DefaultRetryPolicy(soketimeout,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);
        RequestQueue requestQueue = Volley.newRequestQueue(UserDetail.this);

        requestQueue.add(stringRequest);
    }

    private void updatedata() {
        String name_text = editname.getText().toString();
        String number_text = editnumber.getText().toString();
        String id_text = editid.getText().toString();
        String date_text = editdate.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbyHXhUJuKtRc1zgXsQzeeliIMNmK83lGIkVKTNw1nuO3aMncvYXnGUtmARkL3ExDXtYQQ/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        detailProgressBar.setVisibility(View.GONE);
                        Toast.makeText(UserDetail.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                detailProgressBar.setVisibility(View.GONE);
                Toast.makeText(UserDetail.this, "errror "+error.networkResponse, Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();

                params.put("action","update");
                params.put("username",name_text);
                params.put("usernumber",number_text);
                params.put("id",id_text);
                params.put("date",date_text);

                return params;

            }
        };

        int soketimeout= 50000;

        RetryPolicy retryPolicy = new DefaultRetryPolicy(soketimeout,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);
        RequestQueue requestQueue = Volley.newRequestQueue(UserDetail.this);

        requestQueue.add(stringRequest);
    }


    private void updatviews() {
        editname.setText(item.getUserName());
        editnumber.setText(item.getUserNumber());
        editid.setText(item.getUserId());
        editdate.setText(item.getUserDate());
    }
    private void getdata() {
        if(getIntent() != null)
        {
            item =(Item) getIntent().getSerializableExtra("mydetail");
        }


    }
    private void bindviews() {
        editname = findViewById(R.id.updateemail);
        editnumber = findViewById(R.id.update_user_number);
        detailProgressBar = findViewById(R.id.detail_progressbar);
        updatebtn = findViewById(R.id.update_btn);
        deletebtn = findViewById(R.id.delete_btn);
        editid= findViewById(R.id.update_user_id);
        editdate = findViewById(R.id.update_user_date);
    }
}