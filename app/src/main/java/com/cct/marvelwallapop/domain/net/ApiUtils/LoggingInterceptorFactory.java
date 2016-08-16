package com.cct.marvelwallapop.domain.net.ApiUtils;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by carloscarrasco on 16/8/16.
 */

public class LoggingInterceptorFactory {

    public Interceptor getLoggingInterceptor() {
        //If Debug
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        //else
        //logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        return logging;
    }
}
