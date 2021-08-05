package com.example.restapiexampl850;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText numberedit;
    Button submitbtn;
    TextView textView;
    ApiServices apiServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberedit = findViewById(R.id.numbereidt);
        submitbtn = findViewById(R.id.submitbtn);
        textView = findViewById(R.id.textview);
apiServices = ApiClient.getRerorfit().create(ApiServices.class);
submitbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String numbertext = numberedit.getText().toString();
        int id = Integer.parseInt(numbertext);

        Call<ArrayList<Comments>> commentslist = apiServices.getcomments(id);
        commentslist.enqueue(new Callback<ArrayList<Comments>>() {
            @Override
            public void onResponse(Call<ArrayList<Comments>> call, Response<ArrayList<Comments>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "error "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuilder stringBuilder = new StringBuilder();
                for(Comments postclass: response.body())
                {
                    stringBuilder.append("id => "+postclass.getId()+"\n");
                    stringBuilder.append("userid => "+postclass.getPostId()+"\n");

                    stringBuilder.append("body => "+postclass.getBody()+"\n");
                    stringBuilder.append("name => "+postclass.getName()+"\n\n");
                }
                textView.setText(stringBuilder.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Comments>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
});
getPostwithfield();
    }

    private void getPostwithfield() {
        Call<PostModel> call = apiServices.getposts(23,"Testing","this is body");
        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "error "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
               PostModel postclass = response.body();

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("id => "+postclass.getId()+"\n");
                stringBuilder.append("userid => "+postclass.getUserId()+"\n");

                stringBuilder.append("body => "+postclass.getBody()+"\n");
                stringBuilder.append("name => "+postclass.getTitle()+"\n\n");

                textView.setText(stringBuilder.toString());

            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {

            }
        });
    }
}