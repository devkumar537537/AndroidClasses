package com.example.myapplication


import com.example.myapplication.usermodels.UserModel
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {

    @GET("posts")
    fun getpostlist() : Call<ArrayList<PostModel>>

   @GET("posts/{id}")
   fun  getpostwithid(
       @Path("id") id:Int
   ): Call<PostModel>


   @GET("comments")
   fun getcommentquery(
       @Query("postId") id:Int
   ): Call<ArrayList<CommentModel>>


   @FormUrlEncoded
   @POST("posts")
   fun createresourc(
       @Field("title") title:String,
       @Field("userId")  userId:Int,
       @Field("body") body:String
   ): Call<PostModel>

   @GET("users")
   fun getusers(): Call<ArrayList<UserModel>>

   @GET("photos")
   fun getphotos() : Call<ArrayList<ImageModel>>
}