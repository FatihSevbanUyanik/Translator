package com.example.translator;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Translation {

    private int code;
    private String lang;
    private String[] text;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }


    private static Retrofit retrofit;
    private static String BASE_URL = "https://translate.yandex.net/api/v1.5/tr.json/";
    public static String KEY = "trnsl.1.1.20190114T171340Z.2d4367e7f6cdffa2.c35ac85e480" +
            "54d8696ab70a48f47de2e91f5330f";


    public static void setupRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static Retrofit getRetrofit() {
        return retrofit;
    }
}