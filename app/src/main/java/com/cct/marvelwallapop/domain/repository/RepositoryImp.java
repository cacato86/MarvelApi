package com.cct.marvelwallapop.domain.repository;

import com.cct.marvelwallapop.data.Character;
import com.cct.marvelwallapop.data.MarvelResponse;
import com.cct.marvelwallapop.domain.net.RemoteRepository;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class RepositoryImp implements RepositoryInterface {


    private final RemoteRepository remoteRepository;

    public RepositoryImp(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    @Override
    public Observable<List<Character>> getCharacters() {
        return remoteRepository.getCharacters()
                .flatMap(new Func1<MarvelResponse, Observable<List<Character>>>() {
                    @Override
                    public Observable<List<Character>> call(MarvelResponse marvelResponse) {
                        return Observable.just(marvelResponse.getResponse().getResults());
                    }
                });
    }
}
