package com.news.newsnewapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    private static Retrofit retrofit=null;
    private static ApiInterface apiClient;
    private static final String BASE_Url="https://newsapi.org/v2/";

    public static ApiInterface getApiInterface()
    {
        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder ()
                    .baseUrl ( BASE_Url )
                    .addConverterFactory ( GsonConverterFactory.create () )
                    .build ();

            apiClient=retrofit.create ( ApiInterface.class );
        }
        return apiClient;
    }
}
