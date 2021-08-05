package com.example.restapipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restapipractice.models.PostModels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostResponse extends AppCompatActivity {
    EditText usertitle,userbody,useridedit;
    Button submit;
    TextView showdata;
    ApiServices apiServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_response);
        connenctxlml();
        apiServices = ApiClient.getRetrobuilder().create(ApiServices.class);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titletext = usertitle.getText().toString().trim();
                String bodytext = userbody.getText().toString().trim();
                String useridtext = useridedit.getText().toString().trim();
                int covnerted = Integer.parseInt(useridtext);
                createdata(titletext,bodytext,covnerted);
            }
        });

    }

    private void createdata(String titletext, String bodytext, int covnerted) {
        Call<PostModels>  callpost = apiServices.getPost(titletext,covnerted,bodytext);


        callpost.enqueue(new Callback<PostModels>() {
            @Override
            public void onResponse(Call<PostModels> call, Response<PostModels> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(PostResponse.this, "error "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                PostModels postModels = response.body();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("id "+postModels.getId()+"\n");
                stringBuilder.append("userid "+postModels.getUserId()+"\n");
                stringBuilder.append("body "+postModels.getBody()+"\n");
                stringBuilder.append("title "+postModels.getTitle()+"\n\n");


                showdata.setText(stringBuilder.toString());

            }

            @Override
            public void onFailure(Call<PostModels> call, Throwable t) {
                Toast.makeText(PostResponse.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connenctxlml() {
        userbody = findViewById(R.id.body);
        usertitle = findViewById(R.id.titleid);
        useridedit = findViewById(R.id.userid);
        submit = findViewById(R.id.getdata);
        showdata = findViewById(R.id.datatextview);
    }
}