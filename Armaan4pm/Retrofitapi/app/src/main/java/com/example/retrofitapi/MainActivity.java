package com.example.retrofitapi;

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
        textView = findViewById(R.id.textviewdata);
        apiServicess= ApiClent.getRerorfit().create(ApiServicess.class);
       // loaddata();
    //resposnewithfield();
        responswithpost();

    }

    private void responswithpost() {
         Call <ResponsItem> call =apiServicess.getparticulr("Android",234,"ligthcolor");
    call.enqueue(new Callback<ResponsItem>() {
        @Override
        public void onResponse(Call<ResponsItem> call, Response<ResponsItem> response) {
            if(!response.isSuccessful())
            {
                Toast.makeText(MainActivity.this, "error "+response.code(), Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            ResponsItem responsItem = response.body();
            stringBuilder.append("id => "+responsItem.getId()+"\n");
            stringBuilder.append("userid => "+responsItem.getUserId()+"\n");
            stringBuilder.append("title => "+responsItem.getTitle()+"\n");
            stringBuilder.append("body => "+responsItem.getBody()+"\n\n");

            textView.setText(stringBuilder.toString());
        }

        @Override
        public void onFailure(Call<ResponsItem> call, Throwable t) {
            Toast.makeText(MainActivity.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });


    }

    private void resposnewithfield() {
      Call<ArrayList<Commentlist>> callitem =   apiServicess.getcomments(4);
      callitem.enqueue(new Callback<ArrayList<Commentlist>>() {
          @Override
          public void onResponse(Call<ArrayList<Commentlist>> call, Response<ArrayList<Commentlist>> response) {
              if(!response.isSuccessful())
              {
                  Toast.makeText(MainActivity.this, "error "+response.code(), Toast.LENGTH_SHORT).show();
                  return;
              }
              StringBuilder stringBuilder = new StringBuilder();
              for( Commentlist responsItem: response.body())
              {
                  stringBuilder.append("id => "+responsItem.getId()+"\n");
                  stringBuilder.append(" Email=> "+responsItem.getEmail()+"\n");
                  stringBuilder.append("Name => "+responsItem.getName()+"\n");
                  stringBuilder.append("body => "+responsItem.getBody()+"\n\n");
              }
              textView.setText(stringBuilder.toString());

          }

          @Override
          public void onFailure(Call<ArrayList<Commentlist>> call, Throwable t) {
              Toast.makeText(MainActivity.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
          }
      });
    }

    private void loaddata() {
         Call<ArrayList<ResponsItem>> call =apiServicess.getallpost();

         call.enqueue(new Callback<ArrayList<ResponsItem>>() {
             @Override
             public void onResponse(Call<ArrayList<ResponsItem>> call, Response<ArrayList<ResponsItem>> response) {
                 if(!response.isSuccessful())
                 {
                     Toast.makeText(MainActivity.this, "error "+response.code(), Toast.LENGTH_SHORT).show();
                     return;
                 }

                 StringBuilder stringBuilder = new StringBuilder();
                 for( ResponsItem responsItem: response.body())
                 {
                     stringBuilder.append("id => "+responsItem.getId()+"\n");
                     stringBuilder.append("userid => "+responsItem.getUserId()+"\n");
                     stringBuilder.append("title => "+responsItem.getTitle()+"\n");
                     stringBuilder.append("body => "+responsItem.getBody()+"\n\n");
                 }
                 textView.setText(stringBuilder.toString());
             }

             @Override
             public void onFailure(Call<ArrayList<ResponsItem>> call, Throwable t) {
                 Toast.makeText(MainActivity.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
             }
         });
    }
}