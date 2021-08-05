package com.example.restapipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restapipractice.models.Comments;
import com.example.restapipractice.models.PostModels;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Commentwithid extends AppCompatActivity {
    TextView comemntst;
    EditText postedit;
    Button submit;
    ApiServices apiServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commentwithid);
        connect();
        apiServices = ApiClient.getRetrobuilder().create(ApiServices.class);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idtext = postedit.getText().toString();
                 int id = Integer.parseInt(idtext);
                getcommenstlist(id);
            }
        });

    }

    private void getcommenstlist(int id) {
        Call<ArrayList<Comments>>  callcomments = apiServices.getcommentslist(id);

        callcomments.enqueue(new Callback<ArrayList<Comments>>() {
            @Override
            public void onResponse(Call<ArrayList<Comments>> call, Response<ArrayList<Comments>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(Commentwithid.this, "error "+response.code(), Toast.LENGTH_SHORT).show();
                    comemntst.setText("Error Occured");
                    return;
                }

                StringBuilder stringBuilder = new StringBuilder();

                for(Comments postModel: response.body())
                {
                    stringBuilder.append("id => "+postModel.getId()+ "\n");
                    stringBuilder.append("postid => "+postModel.getPostId()+ "\n");
                    stringBuilder.append("email => "+postModel.getEmail()+ "\n");
                    stringBuilder.append("body => "+postModel.getBody()+"\n\n");

                }

                comemntst.setText(stringBuilder.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Comments>> call, Throwable t) {
                Toast.makeText(Commentwithid.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connect() {
        comemntst = findViewById(R.id.commenttextview);
        postedit = findViewById(R.id.postidtext);
        submit = findViewById(R.id.getresponsebtn);
    }
}