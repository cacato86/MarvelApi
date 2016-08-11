package com.cct.marvelwallapop.di.component;

import android.content.Context;

import com.cct.marvelwallapop.MainActivity;
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

    //If other component depends on this, this methods offers this objects to his sons
    Context provideContext();

    RepositoryInterface provideRepository();

    void inject(MainActivity mainActivity);

}
