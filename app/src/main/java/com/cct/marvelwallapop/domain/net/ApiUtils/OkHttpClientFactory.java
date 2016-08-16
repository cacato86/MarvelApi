package com.cct.marvelwallapop.domain.net.ApiUtils;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created by carloscarrasco on 15/8/16.
 */

public class OkHttpClientFactory {

    private final Interceptor logging_interceptor;
    private final Interceptor query_interceptor;

    public OkHttpClientFactory(Interceptor logging, Interceptor query) {
        this.logging_interceptor = logging;
        this.query_interceptor = query;
    }

    public OkHttpClient getOkhttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging_interceptor);
        httpClient.addInterceptor(query_interceptor);
        return httpClient.build();
    }
}
