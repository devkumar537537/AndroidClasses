package com.example.restapiexampleonjava;

import com.example.restapiexampleonjava.models.NowPlayingModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyMovieServices {
    @GET("movie/now_playing")
    Call<NowPlayingModel> getnowplayingmovies(@Query("api_key") String api_key,
                                              @Query("language") String language,
    @Query("page") int page
    );
}
