package com.example.themoviedbapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {


       static String BASE_URL = "https://api.themoviedb.org/3/";
        static Retrofit getRetrofit() {
            retrofit2.Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;

        }
}