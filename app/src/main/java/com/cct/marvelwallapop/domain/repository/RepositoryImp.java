package com.cct.marvelwallapop.domain.repository;

import com.cct.marvelwallapop.data.Character;
import com.cct.marvelwallapop.domain.net.MarvelApiAdapter;

import rx.Observable;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class RepositoryImp implements RepositoryInterface {

    private final MarvelApiAdapter marvelApiAdapter;

    public RepositoryImp(MarvelApiAdapter marvelApiAdapter) {
        this.marvelApiAdapter = marvelApiAdapter;
    }

    @Override
    public Observable<Character> getCharacters() {
        return marvelApiAdapter.getRestAdapter().getCharacters();
    }
}
