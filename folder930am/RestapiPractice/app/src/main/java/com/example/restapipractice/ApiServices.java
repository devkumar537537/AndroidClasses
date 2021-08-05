package com.example.restapipractice;

import com.example.restapipractice.models.Comments;
import com.example.restapipractice.models.PostModels;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServices {


    @GET("posts")
    Call<ArrayList<PostModels>>  getpostlists();

    @GET("posts/{id}/comments")
    Call<ArrayList<Comments>> getcommentslist(
            @Path("id") int id
    );

    @FormUrlEncoded
    @POST("posts")
    Call<PostModels> getPost(
            @Field("title") String title,
            @Field("userId") int userId,
            @Field("body") String body
    );


}
