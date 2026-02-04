package com.example.ygagent.model.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private static Retrofit retrofit;
    public static Retrofit get(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl("https://api.xxx.com/")
                    .client(HttpClientFactory.get())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
