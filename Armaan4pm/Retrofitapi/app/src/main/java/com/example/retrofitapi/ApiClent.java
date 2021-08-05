package com.example.retrofitapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClent {
    static String BASE_URL = "https://jsonplaceholder.typicode.com/";

        static Retrofit getRerorfit()
    {
        retrofit2.Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }



}
