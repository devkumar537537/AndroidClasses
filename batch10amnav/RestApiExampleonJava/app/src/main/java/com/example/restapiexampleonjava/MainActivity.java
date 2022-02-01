package com.example.restapiexampleonjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restapiexampleonjava.models.PostModels;
import com.example.restapiexampleonjava.utils.Commonfunctions;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView textView;
ApiServices apiServices;
Commonfunctions commonfunctions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textviewdata);
        apiServices = ApiClient.getretrofitebuilder().create(ApiServices.class);
    commonfunctions = new Commonfunctions(getApplicationContext());
       Call<ArrayList<PostModels>> calllist =  apiServices.getlists();
getpostwithpost();
//getnormalpost();

    }

    private void getnormalpost() {
        Call<ArrayList<PostModels>> calllist =  apiServices.getlists();
        calllist.enqueue(new Callback<ArrayList<PostModels>>() {
            @Override
            public void onResponse(Call<ArrayList<PostModels>> call, Response<ArrayList<PostModels>> response) {
                if(!response.isSuccessful())
                {
                    commonfunctions.showtoast("error "+response.message());
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();

                for(PostModels postclass : response.body())
                {
                    stringBuilder.append("id => "+postclass.getId()+"\n");
                    stringBuilder.append("userid => "+postclass.getUserId()+"\n");
                    stringBuilder.append("title=> "+postclass.getTitle()+"\n");
                    stringBuilder.append("body => "+postclass.getBody()+"\n\n");


                }
                textView.setText(stringBuilder);

            }

            @Override
            public void onFailure(Call<ArrayList<PostModels>> call, Throwable t) {
                commonfunctions.showtoast("error "+t.getMessage());
            }
        });
    }

    private void getpostwithpost() {
        String title = "somethidng";
        String bodytext = "skishfsaldf";
        int userIdtext = 34;

        Call<PostModels> call = apiServices.getposte(title,bodytext,userIdtext);
        call.enqueue(new Callback<PostModels>() {
            @Override
            public void onResponse(Call<PostModels> call, Response<PostModels> response) {
                if(!response.isSuccessful())
                {
                    commonfunctions.showtoast("error "+response.message());
                    return;
                }

PostModels postclass = response.body();
         StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("id => "+postclass.getId()+"\n");
                    stringBuilder.append("userid => "+postclass.getUserId()+"\n");
                    stringBuilder.append("title=> "+postclass.getTitle()+"\n");
                    stringBuilder.append("body => "+postclass.getBody()+"\n\n");



                textView.setText(stringBuilder);
            }

            @Override
            public void onFailure(Call<PostModels> call, Throwable t) {
commonfunctions.showtoast("errror "+t.getMessage());
            }
        });

    }


}