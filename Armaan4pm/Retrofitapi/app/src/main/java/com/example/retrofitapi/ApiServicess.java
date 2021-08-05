package com.example.retrofitapi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServicess {
    @GET("posts")
    Call<ArrayList<ResponsItem>> getallpost();

  @GET("posts/{id}/comments")
   Call<ArrayList<Commentlist>>  getcomments(
         @Path("id") int id
  );

  @FormUrlEncoded
    @POST("posts")
    Call<ResponsItem> getparticulr(
          @Field("title") String title,
          @Field("userId") int userId,
          @Field("body") String body
  );

}
