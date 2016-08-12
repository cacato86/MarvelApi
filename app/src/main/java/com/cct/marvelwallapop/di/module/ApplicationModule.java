package com.cct.marvelwallapop.di.module;

/**
 * Created by carloscarrasco on 11/8/16.
 */

import android.app.Application;
import android.content.Context;

import com.cct.marvelwallapop.domain.net.ApiUtils.GenerateHash;
import com.cct.marvelwallapop.domain.net.ApiUtils.GenerateTime;
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

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    public RepositoryInterface provideRepository() {
        GenerateHash generateHash = new GenerateHash();
        GenerateTime generateTime = new GenerateTime();
        MarvelApiClient marvelApiClient = new MarvelApiClient(generateHash, generateTime);

        RemoteRepository remoteRepository = new RemoteRepository(marvelApiClient);

        return new RepositoryImp(remoteRepository);
    }


}
