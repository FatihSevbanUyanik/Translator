package com.example.translator;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface TranslationApi {

    @GET("translate")
    Call<Translation> translate(@QueryMap Map<String, String> options);
}
