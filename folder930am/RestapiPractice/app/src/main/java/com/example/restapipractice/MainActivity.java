package com.example.restapipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restapipractice.models.PostModels;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView responstextview;
ApiServices apiServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responstextview = findViewById(R.id.restposntext);

        apiServices =  ApiClient.getRetrobuilder().create(ApiServices.class);
        getpostlists();
    }

    private void getpostlists() {

         Call<ArrayList<PostModels>>  call = apiServices.getpostlists();

         call.enqueue(new Callback<ArrayList<PostModels>>() {
             @Override
             public void onResponse(Call<ArrayList<PostModels>> call, Response<ArrayList<PostModels>> response) {

                 if(!response.isSuccessful())
                 {
                     Toast.makeText(MainActivity.this, "error "+response.code(), Toast.LENGTH_SHORT).show();
                     responstextview.setText("Error Occured");
                     return;
                 }

                 StringBuilder stringBuilder = new StringBuilder();

                 for(PostModels postModel: response.body())
                 {
                     stringBuilder.append("id => "+postModel.getId()+ "\n");
                     stringBuilder.append("userid => "+postModel.getUserId()+ "\n");
                     stringBuilder.append("title => "+postModel.getTitle()+ "\n");
                     stringBuilder.append("body => "+postModel.getBody()+"\n\n");

                 }

                 responstextview.setText(stringBuilder.toString());

             }

             @Override
             public void onFailure(Call<ArrayList<PostModels>> call, Throwable t) {
                 Toast.makeText(MainActivity.this, "eroror "+t.getMessage(), Toast.LENGTH_SHORT).show();
             }
         });
    }
}