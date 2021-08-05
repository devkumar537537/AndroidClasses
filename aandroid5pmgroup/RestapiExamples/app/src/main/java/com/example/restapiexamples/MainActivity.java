package com.example.restapiexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView textView;
ApiServicess apiServicess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        apiServicess = ApiClient.getRerorfit().create(ApiServicess.class);

        //getposts();
      //  getcommentposts();
        getposstwithfields();
    }

    private void getposstwithfields() {
        Call<PostModel> call = apiServicess.getpostwithfields("First","TESting of first",103);
   call.enqueue(new Callback<PostModel>() {
       @Override
       public void onResponse(Call<PostModel> call, Response<PostModel> response) {
           if(!response.isSuccessful())
           {
               Toast.makeText(MainActivity.this, "error "+response.code(), Toast.LENGTH_SHORT).show();
               return;
           }

           StringBuilder stringBuilder = new StringBuilder();

           PostModel postModel = response.body();
           stringBuilder.append("id => "+postModel .getId()+"\n");
           stringBuilder.append("userid => "+postModel .getUserId()+"\n");

           stringBuilder.append("body => "+postModel .getBody()+"\n");
           stringBuilder.append("name => "+postModel .getTitle()+"\n\n");

           textView.setText(stringBuilder.toString());

       }

       @Override
       public void onFailure(Call<PostModel> call, Throwable t) {

       }
   });

    }

    private void getcommentposts() {
        Call<ArrayList<CommentModel>> call = apiServicess.getcommentlist(5);
        call.enqueue(new Callback<ArrayList<CommentModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CommentModel>> call, Response<ArrayList<CommentModel>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "error "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuilder stringBuilder = new StringBuilder();

                for(CommentModel postclass : response.body())
                {
                    stringBuilder.append("id => "+postclass.getId()+"\n");
                    stringBuilder.append("userid => "+postclass.getPostId()+"\n");

                    stringBuilder.append("body => "+postclass.getBody()+"\n");
                    stringBuilder.append("name => "+postclass.getName()+"\n\n");
                }

                textView.setText(stringBuilder.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<CommentModel>> call, Throwable t) {

            }
        });
    }

    private void getposts() {
     Call<ArrayList<PostModel>> call = apiServicess.getalldata();

     call.enqueue(new Callback<ArrayList<PostModel>>() {
         @Override
         public void onResponse(Call<ArrayList<PostModel>> call, Response<ArrayList<PostModel>> response) {

             if(!response.isSuccessful())
             {
                 Toast.makeText(MainActivity.this, "error "+response.code(), Toast.LENGTH_SHORT).show();
                 return;
             }

             StringBuilder stringBuilder = new StringBuilder();

             for(PostModel postclass : response.body())
             {
                 stringBuilder.append("id => "+postclass.getId()+"\n");
                 stringBuilder.append("userid => "+postclass.getUserId()+"\n");

                 stringBuilder.append("body => "+postclass.getBody()+"\n");
                 stringBuilder.append("name => "+postclass.getTitle()+"\n\n");
             }

             textView.setText(stringBuilder.toString());
         }

         @Override
         public void onFailure(Call<ArrayList<PostModel>> call, Throwable t) {
             Toast.makeText(MainActivity.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
         }
     });
    }
}