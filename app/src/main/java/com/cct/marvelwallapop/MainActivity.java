package com.cct.marvelwallapop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cct.marvelwallapop.domain.net.MarvelApiAdapter;
import com.cct.marvelwallapop.domain.net.MarvelApiInterface;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private MarvelApiAdapter marvelApiAdapter = new MarvelApiAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MarvelApiInterface client = marvelApiAdapter.getRestAdapter();
        client.getCharacters()
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
