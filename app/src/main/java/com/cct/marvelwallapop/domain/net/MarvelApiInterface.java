package com.cct.marvelwallapop.domain.net;

import com.cct.marvelwallapop.data.Character;
import com.cct.marvelwallapop.data.MarvelResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by carloscarrasco on 10/8/16.
 */

public interface MarvelApiInterface {

    @GET("v1/public/characters")
    Observable<MarvelResponse> getCharacters();
}
