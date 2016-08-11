package com.cct.marvelwallapop.domain.net;

import com.cct.marvelwallapop.data.Character;
import com.cct.marvelwallapop.data.MarvelResponse;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class RemoteRepository implements MarvelApiInterface {


    private final MarvelApiClient client;

    public RemoteRepository(MarvelApiClient client) {
        this.client = client;
    }

    @Override
    public Observable<MarvelResponse> getCharacters() {
        return client.getRestAdapter().getCharacters();
    }
}
