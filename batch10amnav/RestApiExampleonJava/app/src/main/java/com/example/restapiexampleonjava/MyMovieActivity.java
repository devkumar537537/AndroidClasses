package com.example.restapiexampleonjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.restapiexampleonjava.models.NowPlayingModel;
import com.example.restapiexampleonjava.models.Results;
import com.example.restapiexampleonjava.utils.Commonfunctions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyMovieActivity extends AppCompatActivity {
ArrayList<Results> movielist;
RecyclerView recyclerView;
MyMovieServices myMovieServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_movie);
        recyclerView = findViewById(R.id.recyclerview);
        movielist = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        myMovieServices = ApiClient.getretrofitformthemoviedb().create(MyMovieServices.class);

        Call<NowPlayingModel> call =myMovieServices.getnowplayingmovies(Commonfunctions.API_KEY,Commonfunctions.Language,2);
        call.enqueue(new Callback<NowPlayingModel>() {
            @Override
            public void onResponse(Call<NowPlayingModel> call, Response<NowPlayingModel> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "no response", Toast.LENGTH_SHORT).show();
                    return;
                }
                NowPlayingModel nowPlayingModel = response.body();
                movielist= nowPlayingModel.getResults();
                CustomMoviewAdapter customMoviewAdapter = new CustomMoviewAdapter(movielist,getApplicationContext());

            recyclerView.setAdapter(customMoviewAdapter);


            }

            @Override
            public void onFailure(Call<NowPlayingModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}