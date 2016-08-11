package com.cct.marvelwallapop.domain.net;

import com.cct.marvelwallapop.domain.net.ApiUtils.GenerateHash;
import com.cct.marvelwallapop.domain.net.ApiUtils.GenerateTime;

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

public class MarvelApiClient {

    private static final String URL_BASE = "http://gateway.marvel.com";

    private static final String TIMESTAMP_KEY = "ts";
    private static final String HASH_KEY = "hash";
    private static final String APIKEY_KEY = "apikey";

    private GenerateHash generateHash;
    private GenerateTime generateTime;
    private MarvelApiInterface client;


    public MarvelApiClient(GenerateHash generateHash, GenerateTime generateTime) {
        this.generateHash = generateHash;
        this.generateTime = generateTime;
    }

    public MarvelApiInterface getRestAdapter() {
        if (client == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(URL_BASE)
                    .client(getOkhttpClient())
                    .build();

            client = retrofit.create(MarvelApiInterface.class);
        }

        return client;
    }

    private OkHttpClient getOkhttpClient() {
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
