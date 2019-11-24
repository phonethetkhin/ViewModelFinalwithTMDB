package com.example.viewmodelfinalwithtmdb.Retrofits;

import com.example.viewmodelfinalwithtmdb.Models.MovieRespondModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apicalls {
    @GET("now_playing")
    Call<MovieRespondModel> getNowPlaying(
            @Query("api_key") String Apikey,
            @Query("page") int PageNumber

    );

    @GET("popular")
    Call<MovieRespondModel> getPopular(

            @Query("api_key") String Apikey,
            @Query("page") int Pagenumber
    );
    @GET("top_rated")
    Call<MovieRespondModel> getTopRated(

            @Query("api_key") String Apikey,
            @Query("page") int Pagenumber
    );
    @GET("upcoming")
    Call<MovieRespondModel> getUpComing(

            @Query("api_key") String Apikey,
            @Query("page") int Pagenumber
    );


}
