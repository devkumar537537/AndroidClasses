package com.example.restapiexampl850;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServices {
    @GET("posts")
    public Call<ArrayList<PostModel>> getalldata();

   @GET("post/{id}/comments")
   Call<ArrayList<Comments>> getcomments(
           @Path("id") int id
   );

   @FormUrlEncoded
   @POST("posts")
    Call<PostModel> getposts(
            @Field("userId") int userid,
            @Field("title") String title,
            @Field("body") String body
   );
}
