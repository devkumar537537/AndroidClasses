package com.cbitss.apipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.cbitss.apipractice.mymodepackage.Address;
import com.cbitss.apipractice.mymodepackage.Company;
import com.cbitss.apipractice.mymodepackage.Geo;
import com.cbitss.apipractice.mymodepackage.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView postviewtext;
ApiServices apiServices;
ArrayList<PostModel> poslistss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postviewtext = findViewById(R.id.mypostdata);
        poslistss = new ArrayList<>();
       apiServices = ApiClient.getRetrofitbuilder().create(ApiServices.class);
      //  getpossts();
//getcomments();
//getpostwithid();
//getlistofusers();
//getcommentwithpostid();
        createpost();
    }

    private void createpost() {
        Call<PostModel> postcall =apiServices.getpostwithpostmethod("Android","123","this is android");
        postcall.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "respons not availble", Toast.LENGTH_SHORT).show();
                    return;
                }
                PostModel postclass = response.body();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("id => "+postclass.getId()+"\n");
                stringBuilder.append("userid => "+postclass.getUserId()+"\n");
                stringBuilder.append("title => "+postclass.getTitle()+"\n");
                stringBuilder.append("body => "+postclass.getBody()+"\n\n");

                postviewtext.setText(stringBuilder+"");
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getcommentwithpostid() {
       Call<ArrayList<CommentModel>> commentlistcall =apiServices.getcommentwithpostid(4);
       commentlistcall.enqueue(new Callback<ArrayList<CommentModel>>() {
           @Override
           public void onResponse(Call<ArrayList<CommentModel>> call, Response<ArrayList<CommentModel>> response) {
               if(!response.isSuccessful())
               {
                   Toast.makeText(MainActivity.this, "response empty", Toast.LENGTH_SHORT).show();

               }

               StringBuilder stringBuilder =new StringBuilder();
               for(CommentModel commentModel: response.body()){
                   stringBuilder.append("email  => "+commentModel.getEmail()+"\n");
                   stringBuilder.append("name => "+commentModel.getName()+"\n\n");
               }
               postviewtext.setText(stringBuilder);
           }

           @Override
           public void onFailure(Call<ArrayList<CommentModel>> call, Throwable t) {
               Toast.makeText(MainActivity.this, "error => "+t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });
    }

    private void getlistofusers() {
        Call<ArrayList<UserModel>> usercall = apiServices.getuserlist();
        usercall.enqueue(new Callback<ArrayList<UserModel>>() {
            @Override
            public void onResponse(Call<ArrayList<UserModel>> call, Response<ArrayList<UserModel>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "respons not availble", Toast.LENGTH_SHORT).show();
                    return;
                }
StringBuilder stringBuilder = new StringBuilder();
                for(UserModel userModel: response.body())
                {
                  Address address = userModel.getAddress();
                    Geo geo = address.getGeo();
                    stringBuilder.append("longitute => "+geo.getLng()+"\n");
                    Company company = userModel.getCompany();
                    stringBuilder.append("Name => "+company.getName()+"\n\n");
                }
                postviewtext.setText(stringBuilder);
            }

            @Override
            public void onFailure(Call<ArrayList<UserModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getpostwithid() {
        int id = 12;
        Call<PostModel> postcall =apiServices.getcommentwithid(id);
        postcall.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "respons not availble", Toast.LENGTH_SHORT).show();
                    return;
                }
            PostModel postclass = response.body();
            StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("id => "+postclass.getId()+"\n");
                    stringBuilder.append("userid => "+postclass.getUserId()+"\n");
                    stringBuilder.append("title => "+postclass.getTitle()+"\n");
                    stringBuilder.append("body => "+postclass.getBody()+"\n\n");

                postviewtext.setText(stringBuilder+"");
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getcomments() {
     Call<ArrayList<CommentModel>> commentcall =   apiServices.getcomments();

     commentcall.enqueue(new Callback<ArrayList<CommentModel>>() {
         @Override
         public void onResponse(Call<ArrayList<CommentModel>> call, Response<ArrayList<CommentModel>> response) {
             if(!response.isSuccessful())
             {
                 Toast.makeText(MainActivity.this, "response empty", Toast.LENGTH_SHORT).show();

             }

             StringBuilder stringBuilder =new StringBuilder();
            for(CommentModel commentModel: response.body()){
                stringBuilder.append("email  => "+commentModel.getEmail()+"\n");
                stringBuilder.append("name => "+commentModel.getName()+"\n\n");
            }
           postviewtext.setText(stringBuilder);
         }

         @Override
         public void onFailure(Call<ArrayList<CommentModel>> call, Throwable t) {
             Toast.makeText(MainActivity.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
         }
     });
    }

    private void getpossts() {
        Call<ArrayList<PostModel>> postList =  apiServices.getposts();
        postList.enqueue(new Callback<ArrayList<PostModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PostModel>> call, Response<ArrayList<PostModel>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "respons not availble", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuilder stringBuilder =new StringBuilder();
                for(PostModel postclass: response.body())
                {
                    stringBuilder.append("id => "+postclass.getId()+"\n");
                    stringBuilder.append("userid => "+postclass.getUserId()+"\n");
                    stringBuilder.append("title => "+postclass.getTitle()+"\n");
                    stringBuilder.append("body => "+postclass.getBody()+"\n\n");
                }
                postviewtext.setText(stringBuilder+"");
            }

            @Override
            public void onFailure(Call<ArrayList<PostModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}