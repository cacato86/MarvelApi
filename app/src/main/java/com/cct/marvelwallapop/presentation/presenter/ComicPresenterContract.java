package com.cct.marvelwallapop.presentation.presenter;

import android.view.View;

import com.cct.marvelwallapop.data.Comic;
import com.cct.marvelwallapop.presentation.activity.ComicViewContract;

/**
 * Created by carloscarrasco on 12/8/16.
 */

public interface ComicPresenterContract {

    void getComics(String character_id);

    void launchDetail(Comic comic, View view);

    void attachView(ComicViewContract view);

    void detachView();
}
