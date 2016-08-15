package com.cct.marvelwallapop.domain.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by carloscarrasco on 10/8/16.
 */

public class MarvelApiClient {

    private static final String URL_BASE = "http://gateway.marvel.com";

    private final OkHttpClient okHttpClient;
    private MarvelApiInterface client;

    public MarvelApiClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public MarvelApiInterface getRestAdapter() {
        if (client == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(URL_BASE)
                    .client(okHttpClient)
                    .build();

            client = retrofit.create(MarvelApiInterface.class);
        }
        return client;
    }
}
