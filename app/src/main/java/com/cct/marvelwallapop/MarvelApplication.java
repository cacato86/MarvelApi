package com.cct.marvelwallapop;

import android.app.Application;

import com.cct.marvelwallapop.di.component.ApplicationComponent;
import com.cct.marvelwallapop.di.component.DaggerApplicationComponent;
import com.cct.marvelwallapop.di.module.ApplicationModule;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class MarvelApplication extends Application {

    private static MarvelApplication instance;
    private ApplicationComponent applicationComponent;

    public static MarvelApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(instance))
                    .build();
        }
        return applicationComponent;
    }
}
