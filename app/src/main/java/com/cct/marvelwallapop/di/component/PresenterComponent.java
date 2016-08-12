package com.cct.marvelwallapop.di.component;

import com.cct.marvelwallapop.di.PerActivity;
import com.cct.marvelwallapop.di.module.PresenterModule;
import com.cct.marvelwallapop.presentation.activity.ComicList;
import com.cct.marvelwallapop.presentation.presenter.ComicPresenterContract;

import dagger.Component;

/**
 * Created by carloscarrasco on 11/8/16.
 */

@PerActivity
@Component(modules = {PresenterModule.class},
        dependencies = {ApplicationComponent.class})
public interface PresenterComponent {

    ComicPresenterContract provideComicPresenter();

    void inject(ComicList comicList);
}
