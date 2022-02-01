package com.example.restapiexampleonjava;

import com.example.restapiexampleonjava.models.PostModels;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {

    @GET("posts")
    Call<ArrayList<PostModels>> getlists();

     @FormUrlEncoded
    @POST("posts")
    Call<PostModels> getposte(@Field("title") String title,
                              @Field("body") String body,
                              @Field("userId") int userId
                              );

}
