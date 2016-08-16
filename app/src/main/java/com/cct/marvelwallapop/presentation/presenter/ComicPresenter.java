package com.cct.marvelwallapop.presentation.presenter;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.cct.marvelwallapop.R;
import com.cct.marvelwallapop.Utils.Constants;
import com.cct.marvelwallapop.data.Comic;
import com.cct.marvelwallapop.domain.net.GenericSubscriber;
import com.cct.marvelwallapop.domain.net.usecase.GetComics;
import com.cct.marvelwallapop.presentation.activity.ComicDetail;
import com.cct.marvelwallapop.presentation.activity.ComicViewContract;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by carloscarrasco on 12/8/16.
 */

public class ComicPresenter implements ComicPresenterContract {

    private GetComics getComics;

    private ComicViewContract view;

    @Inject
    public ComicPresenter(GetComics getComics) {
        this.getComics = getComics;
    }

    @Override
    public void attachView(ComicViewContract view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void getComics(String character_id) {
        getComics.setParameters(Constants.CHARACTER_ID);
        getComics.subscribe(new GenericSubscriber<List<Comic>>() {
            @Override
            public void onNext(List<Comic> comics) {
                view.getComics(comics);
            }
        });
    }

    @Override
    public void launchDetail(Comic comic, View imageView) {
        Intent intent = new Intent(view.getActivity(), ComicDetail.class);
        intent.putExtra("comic", comic);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(view.getActivity(), imageView,
                            view.getActivity().getString(R.string.image_detail_trans));
            ActivityCompat.startActivity(view.getActivity(), intent, options.toBundle());
        } else {
            view.getActivity().startActivity(intent);
        }
    }
}
