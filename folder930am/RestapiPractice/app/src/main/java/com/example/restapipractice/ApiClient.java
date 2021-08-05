package com.example.restapipractice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    static Retrofit getRetrobuilder()
    {
        retrofit2.Retrofit retrofitbuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitbuilder;
    }
}
