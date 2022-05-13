package com.cbitss.restapiexample;

import com.cbitss.restapiexample.complextresponse.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

@GET("albums")
public Call<ArrayList<AlbumModel>> getalbubs();

@GET("comments")
    Call<ArrayList<CoomentModel>> getcomments(
            @Query("postId") int postId

);

@GET("posts/{id}/comments")
    Call<ArrayList<CoomentModel>> getcommentwithid(
            @Path("id") int id
);

@FormUrlEncoded
@POST("posts")
Call<PostModel> getpost(
        @Field("title") String title,
        @Field("body") String body,
        @Field("userId") int userid
);

@GET("users")
    Call<ArrayList<UserModel>> getuserlist();
}
