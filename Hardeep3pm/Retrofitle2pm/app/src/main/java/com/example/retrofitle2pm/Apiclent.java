package com.example.retrofitle2pm;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclent {
    static String BASE_URL = "http://anwclub.online/api/";
    static Retrofit getRetrofit()
    {
        retrofit2.Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
