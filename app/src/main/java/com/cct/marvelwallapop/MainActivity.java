package com.cct.marvelwallapop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cct.marvelwallapop.di.InjectorHelper;
import com.cct.marvelwallapop.domain.repository.RepositoryInterface;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    RepositoryInterface repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InjectorHelper.getApplicationComponent().inject(this);

        repository.getCharacters()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        character -> {
                            Log.e("Character", character.toString());
                        }, error -> {
                            Log.e("Error: ", error.toString());
                        });
    }
}
