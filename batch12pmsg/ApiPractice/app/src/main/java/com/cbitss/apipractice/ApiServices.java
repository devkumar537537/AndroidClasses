package com.cbitss.apipractice;

import com.cbitss.apipractice.mymodepackage.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServices {


    @GET("posts")
    Call<ArrayList<PostModel>> getposts();


    @GET("comments")
    Call<ArrayList<CommentModel>> getcomments();

    @GET("posts/{id}")
    Call<PostModel> getcommentwithid(
            @Path("id") int id
    );

    @GET("users")
    Call<ArrayList<UserModel>> getuserlist();


    @GET("comments")
   Call<ArrayList<CommentModel>> getcommentwithpostid(
           @Query("postId") int postId
    );

    @FormUrlEncoded
    @POST("posts")
    Call<PostModel> getpostwithpostmethod(
            @Field("title") String title,
            @Field("userId") String userId,
            @Field("body") String body
    );
}
