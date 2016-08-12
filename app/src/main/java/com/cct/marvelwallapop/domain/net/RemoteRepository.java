package com.cct.marvelwallapop.domain.net;

import com.cct.marvelwallapop.data.MarvelResponse;

import rx.Observable;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class RemoteRepository implements MarvelApiInterface {


    private final MarvelApiClient client;

    public RemoteRepository(MarvelApiClient client) {
        this.client = client;
    }

    @Override
    public Observable<MarvelResponse> getComics(String character_id) {
        return client.getRestAdapter().getComics(character_id);
    }
}
