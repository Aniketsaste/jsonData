package com.news.newsnewapp.retrofit;

import com.news.newsnewapp.model.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("top-headlines")
    Call<MainModel> getCategoryNews(
            @Query ( "country" ) String country,
            @Query ( "category" ) String category,
            @Query ( "pagesize" ) int page,
            @Query ( "apiKey" ) String apikey

    );
}
