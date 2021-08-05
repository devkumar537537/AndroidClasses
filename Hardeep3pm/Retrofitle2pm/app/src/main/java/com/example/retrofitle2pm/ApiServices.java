package com.example.retrofitle2pm;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServices {
    @GET("read.php")
    Call<ArrayList<DataModel>> getPostList();

    @FormUrlEncoded
    @POST("create.php")
    Call<Creadtresponse> getPsotWithField(
            @Field("title") String title,
            @Field("body") String body
    );
}
