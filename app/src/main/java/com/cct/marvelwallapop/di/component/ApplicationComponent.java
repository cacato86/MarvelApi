package com.cct.marvelwallapop.di.component;

import android.content.Context;

import com.cct.marvelwallapop.di.module.ApplicationModule;
import com.cct.marvelwallapop.domain.repository.RepositoryInterface;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by carloscarrasco on 11/8/16.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context provideContext();

    RepositoryInterface provideRepository();
}
