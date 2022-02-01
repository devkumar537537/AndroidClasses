package com.example.restapiexampleonjava;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL="https://jsonplaceholder.typicode.com/";
public static final String BASE_URLM="https://api.themoviedb.org/3/";
    static Retrofit getretrofitebuilder()
    {
        retrofit2.Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    static  Retrofit getretrofitformthemoviedb()
    {
        retrofit2.Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URLM)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
