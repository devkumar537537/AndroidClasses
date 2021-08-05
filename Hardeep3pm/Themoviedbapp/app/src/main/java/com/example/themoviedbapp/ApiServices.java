package com.example.themoviedbapp;

import com.example.themoviedbapp.models.Root;

import retrofit2.Call;
import retrofit2.http.GET;

interface ApiServices {

    @GET("movie/550?api_key=925f18a206f7c7a799534028b372c6b0")
    Call<Root> getresponsee();

    @GET("movie/{movie_id}?api_key=925f18a206f7c7a799534028b372c6b0")
    Call<Root> getresponseewithid();
}
