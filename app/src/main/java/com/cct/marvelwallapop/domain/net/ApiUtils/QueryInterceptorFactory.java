package com.cct.marvelwallapop.domain.net.ApiUtils;

import com.cct.marvelwallapop.Utils.Constants;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;

import static com.cct.marvelwallapop.Utils.Constants.APIKEY_PUBLIC;

/**
 * Created by carloscarrasco on 16/8/16.
 */

public class QueryInterceptorFactory {

    private static final String TIMESTAMP_KEY = "ts";
    private static final String HASH_KEY = "hash";
    private static final String APIKEY_KEY = "apikey";

    private final GenerateHash generateHash;
    private final GenerateTime generateTime;

    public QueryInterceptorFactory(GenerateHash generateHash, GenerateTime generateTime) {
        this.generateHash = generateHash;
        this.generateTime = generateTime;
    }

    public Interceptor getQueryInterceptor() {
        return chain -> {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();
            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter(TIMESTAMP_KEY, String.valueOf(generateTime.getTimeStamp()))
                    .addQueryParameter(APIKEY_KEY, APIKEY_PUBLIC)
                    .addQueryParameter(HASH_KEY, generateHash.getMd5Hash(generateTime.getTimeStamp(),
                            Constants.APIKEY_PRIVATE, Constants.APIKEY_PUBLIC))
                    .build();
            Request.Builder requestBuilder = original.newBuilder().url(url);
            Request request = requestBuilder.build();
            return chain.proceed(request);
        };
    }
}
