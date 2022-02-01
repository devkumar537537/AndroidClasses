package com.example.spreasheetexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyPasswordlist extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<Item> userlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_passwordlist);
        recyclerView = findViewById(R.id.userrecyclerview);
        userlist =new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        showuserlist();

    }

    private void showuserlist() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://script.google.com/macros/s/AKfycbxOQ-A_egwFNSWYD1KJUpXevpPSmGg4ZF3kaWTHKr5e-0p8X5PdgMPFREGTqw2Nzo5j/exec?action=getItems",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                      parsresponse(response);
                        Toast.makeText(MyPasswordlist.this, response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "error "+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        int soketimeout= 50000;

        RetryPolicy retryPolicy = new DefaultRetryPolicy(soketimeout,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);
        RequestQueue requestQueue = Volley.newRequestQueue(MyPasswordlist.this);

        requestQueue.add(stringRequest);
    }

    private void parsresponse(String response) {


        try {
           JSONObject  jsonObject = new JSONObject(response);
           // JSONArray jsonArray = jobj.getJSONArray("items");
//            for(int i=0;i<jsonArray.length();i++)
//            {
//                JSONObject jo = jsonArray.getJSONObject(i);
//
//                EamilModels student = new EamilModels();
//
//                student.setEmail(jo.getString("email"));
//                student.setNumber(jo.getString("number"));
//                student.setId(jo.getString("id"));
//                student.setDate(jo.getString("date"));
//                arraylist.add(student);
//            }

            JSONArray jsonArray = jsonObject.getJSONArray("items");

            for(int i =0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Item item = new Item();
                item.setUserdate(jsonObject1.getString("userdate"));
                item.setUsername(jsonObject1.getString("username"));
                item.setUserId(jsonObject1.getString("userId"));
                item.setUserpassword(jsonObject1.getString("userpassword"));

                userlist.add(item);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

MyPasswordAdapter myPasswordAdapter =new MyPasswordAdapter(userlist,getApplicationContext());
        recyclerView.setAdapter(myPasswordAdapter);

    }
}