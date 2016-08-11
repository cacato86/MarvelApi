
package com.cct.marvelwallapop.di;

import com.cct.marvelwallapop.MarvelApplication;
import com.cct.marvelwallapop.di.component.ApplicationComponent;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class InjectorHelper {

    public static ApplicationComponent getApplicationComponent() {
        return MarvelApplication.getInstance().getApplicationComponent();
    }

    /*public static PresenterComponent getPresenterComponent(Activity activityScope) {
        return DaggerPresenterComponent.builder()
                .applicationComponent(App.getInstance().getApplicationComponent())
                .navigatorModule(new NavigatorModule(activityScope))
                .presenterModule(new PresenterModule())
                .build();
    }*/

}
