package com.cct.marvelwallapop.presentation.activity;

import android.app.Activity;

import com.cct.marvelwallapop.data.Comic;

import java.util.List;

/**
 * Created by carloscarrasco on 12/8/16.
 */

public interface ComicViewContract {
    void getComics(List<Comic> comics);

    Activity getActivity();
}
