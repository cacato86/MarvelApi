package com.cct.marvelwallapop.domain.repository;

import com.cct.marvelwallapop.data.Comic;
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
    public Observable<List<Comic>> getComics(String character_id) {
        return remoteRepository.getComics(character_id)
                .flatMap(new Func1<MarvelResponse, Observable<List<Comic>>>() {
                    @Override
                    public Observable<List<Comic>> call(MarvelResponse marvelResponse) {
                        return Observable.just(marvelResponse.getResponse().getResults());
                    }
                });
    }
}
