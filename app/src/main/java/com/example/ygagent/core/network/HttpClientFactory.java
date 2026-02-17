package com.example.ygagent.core.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class HttpClientFactory {

    private static OkHttpClient client;

    public static OkHttpClient get() {
        if (client == null) {
            client = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();
        }
        return client;
    }
}
