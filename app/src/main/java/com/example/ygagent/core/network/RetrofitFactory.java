package com.example.ygagent.core.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private static Retrofit retrofit;
    public static Retrofit get(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl("http://139.199.70.159:8088/")
                    .client(HttpClientFactory.get())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
