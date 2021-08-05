package com.example.restapiexamples;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServicess {

    @GET("posts")
    public Call<ArrayList<PostModel>> getalldata();

    @GET("posts/{id}/comments")
    public Call<ArrayList<CommentModel>> getcommentlist(
            @Path("id") int id
    );

    @FormUrlEncoded
    @POST("posts")
    public Call<PostModel> getpostwithfields(
            @Field("title") String title,
            @Field("body") String body,
            @Field("userId") int userId
    );
}
