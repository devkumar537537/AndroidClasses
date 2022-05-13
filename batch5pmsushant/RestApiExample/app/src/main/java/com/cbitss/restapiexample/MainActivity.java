package com.cbitss.restapiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.cbitss.restapiexample.complextresponse.Address;
import com.cbitss.restapiexample.complextresponse.Company;
import com.cbitss.restapiexample.complextresponse.Geo;
import com.cbitss.restapiexample.complextresponse.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView textView;

ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        apiService = ApiClient.getRetrofitbuilder().create(ApiService.class);
       // getlist();
      //  getcommentwithpostId();
        //getcommentwithid();
        //getpostid();
        getuserlist();
    }

    private void getuserlist() {
       Call<ArrayList<UserModel>> usercall =  apiService.getuserlist();
       usercall.enqueue(new Callback<ArrayList<UserModel>>() {
           @Override
           public void onResponse(Call<ArrayList<UserModel>> call, Response<ArrayList<UserModel>> response) {
               if(!response.isSuccessful())
               {
                   Toast.makeText(MainActivity.this, "response not successfull", Toast.LENGTH_SHORT).show();
               }
             StringBuilder stringBuilder = new StringBuilder();
              for(UserModel userModel : response.body())
              {
                  Company company = userModel.getCompany();
                  Address address = userModel.getAddress();
                  Geo geo = address.getGeo();

                  stringBuilder.append("value from compane =>  "+company.getName()+"\n");
                  stringBuilder.append("value from address => "+address.getZipcode()+"\n");
                  stringBuilder.append("value from geo => "+geo.getLat()+"\n\n");
              }
              textView.setText(stringBuilder);
           }

           @Override
           public void onFailure(Call<ArrayList<UserModel>> call, Throwable t) {
               Toast.makeText(MainActivity.this, "error => "+t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });
    }

    private void getpostid() {
        Call<PostModel> getposts = apiService.getpost("Android","This is testing",34);
        getposts.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "response not successfull", Toast.LENGTH_SHORT).show();
                }
                PostModel postModel = response.body();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" id  => "+postModel.getId()+"\n");
                stringBuilder.append("userID => "+postModel.getUserID()+"\n");
                stringBuilder.append(" Title => "+postModel.getBody()+"\n\n");
                textView.setText(stringBuilder);
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error => "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getcommentwithid() {
       Call<ArrayList<CoomentModel>> arraylist =  apiService.getcommentwithid(4);
       arraylist.enqueue(new Callback<ArrayList<CoomentModel>>() {
           @Override
           public void onResponse(Call<ArrayList<CoomentModel>> call, Response<ArrayList<CoomentModel>> response) {
               if(!response.isSuccessful())
               {
                   Toast.makeText(MainActivity.this, "response not successfull", Toast.LENGTH_SHORT).show();
               }
               StringBuilder stringBuilder =  new StringBuilder();
               for(CoomentModel coomentModel: response.body())
               {
                   stringBuilder.append(" id  => "+coomentModel.getId()+"\n");
                   stringBuilder.append("userID => "+coomentModel.getEmail()+"\n");
                   stringBuilder.append(" Title => "+coomentModel.getBody()+"\n\n");

               }

               textView.setText(stringBuilder);
           }

           @Override
           public void onFailure(Call<ArrayList<CoomentModel>> call, Throwable t) {
               Toast.makeText(MainActivity.this, "error => "+t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });

    }

    private void getcommentwithpostId() {
        Call<ArrayList<CoomentModel>> commentmodel = apiService.getcomments(4);
        commentmodel.enqueue(new Callback<ArrayList<CoomentModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CoomentModel>> call, Response<ArrayList<CoomentModel>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "response not successfull", Toast.LENGTH_SHORT).show();
                }
                StringBuilder stringBuilder =  new StringBuilder();
                for(CoomentModel coomentModel: response.body())
                {
                    stringBuilder.append(" id  => "+coomentModel.getId()+"\n");
                    stringBuilder.append("userID => "+coomentModel.getEmail()+"\n");
                    stringBuilder.append(" Title => "+coomentModel.getBody()+"\n\n");

                }

                textView.setText(stringBuilder);
            }

            @Override
            public void onFailure(Call<ArrayList<CoomentModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error => "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getlist() {
       Call<ArrayList<AlbumModel>> callenqu = apiService.getalbubs();

       callenqu.enqueue(new Callback<ArrayList<AlbumModel>>() {
           @Override
           public void onResponse(Call<ArrayList<AlbumModel>> call, Response<ArrayList<AlbumModel>> response) {
          if(!response.isSuccessful())
          {
              Toast.makeText(MainActivity.this, "response not successfull", Toast.LENGTH_SHORT).show();
          }
          StringBuilder stringBuilder =  new StringBuilder();
          for(AlbumModel albumModel: response.body())
          {
              stringBuilder.append(" id  => "+albumModel.getId()+"\n");
              stringBuilder.append("userID => "+albumModel.getUserId()+"\n");
              stringBuilder.append(" Title => "+albumModel.getTitle()+"\n\n");

          }

          textView.setText(stringBuilder);
           }

           @Override
           public void onFailure(Call<ArrayList<AlbumModel>> call, Throwable t) {
               Toast.makeText(MainActivity.this, "error => "+t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });
    }
}