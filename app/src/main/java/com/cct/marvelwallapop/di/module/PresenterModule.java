package com.cct.marvelwallapop.di.module;

/**
 * Created by carloscarrasco on 11/8/16.
 */

import com.cct.marvelwallapop.di.PerActivity;
import com.cct.marvelwallapop.domain.net.usecase.GetComics;
import com.cct.marvelwallapop.presentation.presenter.ComicPresenter;
import com.cct.marvelwallapop.presentation.presenter.ComicPresenterContract;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @PerActivity
    public ComicPresenterContract provideComicPresenter(GetComics getComics) {
        return new ComicPresenter(getComics);
    }

}
