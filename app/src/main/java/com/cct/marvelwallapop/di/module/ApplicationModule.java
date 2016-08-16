package com.cct.marvelwallapop.di.module;

/**
 * Created by carloscarrasco on 11/8/16.
 */

import android.app.Application;
import android.content.Context;

import com.cct.marvelwallapop.domain.net.ApiUtils.GenerateHash;
import com.cct.marvelwallapop.domain.net.ApiUtils.GenerateTime;
import com.cct.marvelwallapop.domain.net.ApiUtils.LoggingInterceptorFactory;
import com.cct.marvelwallapop.domain.net.ApiUtils.OkHttpClientFactory;
import com.cct.marvelwallapop.domain.net.ApiUtils.QueryInterceptorFactory;
import com.cct.marvelwallapop.domain.net.MarvelApiClient;
import com.cct.marvelwallapop.domain.net.RemoteRepository;
import com.cct.marvelwallapop.domain.repository.RepositoryImp;
import com.cct.marvelwallapop.domain.repository.RepositoryInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;
    private OkHttpClientFactory okHttpClientFactory;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    public OkHttpClientFactory provideOkhttpClient(){
        GenerateTime generateTime = new GenerateTime();
        GenerateHash generateHash = new GenerateHash();

        QueryInterceptorFactory queryInterceptor = new QueryInterceptorFactory(generateHash, generateTime);
        LoggingInterceptorFactory loggingInterceptor = new LoggingInterceptorFactory();
        okHttpClientFactory = new OkHttpClientFactory(
                loggingInterceptor.getLoggingInterceptor(), queryInterceptor.getQueryInterceptor());
        return this.okHttpClientFactory;
    }

    @Provides
    @Singleton
    public RepositoryInterface provideRepository(OkHttpClientFactory okHttpClientFactory) {

        MarvelApiClient marvelApiClient = new MarvelApiClient(okHttpClientFactory.getOkhttpClient());

        RemoteRepository remoteRepository = new RemoteRepository(marvelApiClient);

        return new RepositoryImp(remoteRepository);
    }


}
