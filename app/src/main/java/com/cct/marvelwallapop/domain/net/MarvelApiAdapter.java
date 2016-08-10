package com.cct.marvelwallapop.domain.net;

import com.cct.marvelwallapop.Constants;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.cct.marvelwallapop.Constants.APIKEY_PUBLIC;

/**
 * Created by carloscarrasco on 10/8/16.
 */

public class MarvelApiAdapter {

    private static final String URL_BASE = "http://gateway.marvel.com";

    private static final String TIMESTAMP_KEY = "ts";
    private static final String HASH_KEY = "hash";
    private static final String APIKEY_KEY = "apikey";

    private GenerateHash generateHash = new GenerateHash();
    private GenerateTime generateTime = new GenerateTime();

    public MarvelApiInterface getRestAdapter() {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL_BASE)
                .client(getRestClient())
                .build();

        return retrofit.create(MarvelApiInterface.class);
    }

    private OkHttpClient getRestClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);

        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();
            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter(TIMESTAMP_KEY, String.valueOf(generateTime.getTimeStamp()))
                    .addQueryParameter(APIKEY_KEY, APIKEY_PUBLIC)
                    .addQueryParameter(HASH_KEY, generateHash.getMd5Hash())
                    .build();
            Request.Builder requestBuilder = original.newBuilder().url(url);
            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        return httpClient.build();
    }

}
