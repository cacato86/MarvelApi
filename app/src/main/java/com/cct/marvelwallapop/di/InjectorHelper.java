
package com.cct.marvelwallapop.di;

import com.cct.marvelwallapop.MarvelApplication;
import com.cct.marvelwallapop.di.component.ApplicationComponent;
import com.cct.marvelwallapop.di.component.DaggerPresenterComponent;
import com.cct.marvelwallapop.di.component.PresenterComponent;
import com.cct.marvelwallapop.di.module.PresenterModule;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class InjectorHelper {

    public static ApplicationComponent getApplicationComponent() {
        return MarvelApplication.getInstance().getApplicationComponent();
    }

    public static PresenterComponent getPresenterComponent() {
        return DaggerPresenterComponent.builder()
                .applicationComponent(MarvelApplication.getInstance().getApplicationComponent())
                .presenterModule(new PresenterModule())
                .build();
    }

}
