package com.cct.marvelwallapop.presentation.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cct.marvelwallapop.R;
import com.cct.marvelwallapop.Utils.Constants;
import com.cct.marvelwallapop.data.Comic;
import com.cct.marvelwallapop.di.InjectorHelper;
import com.cct.marvelwallapop.presentation.adapter.ComicListAdapter;
import com.cct.marvelwallapop.presentation.presenter.ComicPresenterContract;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class ComicList extends AppCompatActivity implements ComicViewContract, ComicListAdapter.onItemClick {

    @BindView(R.id.recycleview)
    RecyclerView recycleView;

    private ComicListAdapter adapter;

    @Inject
    ComicPresenterContract comicPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);
        ButterKnife.bind(this);
        InjectorHelper.getPresenterComponent().inject(this);

        recycleView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recycleView.setLayoutManager(llm);
        //Dagger
        adapter = new ComicListAdapter();
        adapter.setListener(this);
        recycleView.setAdapter(adapter);

        getData();
    }

    private void getData() {
        comicPresenter.getComics(Constants.CHARACTER_ID);
    }

    @Override
    protected void onResume() {
        super.onResume();
        comicPresenter.attachView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        comicPresenter.detachView();
    }

    @Override
    public void getComics(List<Comic> comics) {
        adapter.setCharactersArray(comics);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void onItemClick(Comic comic, View view) {
        comicPresenter.launchDetail(comic, view);
    }
}
