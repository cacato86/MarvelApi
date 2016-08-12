package com.cct.marvelwallapop.domain.net;

import com.cct.marvelwallapop.data.MarvelResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by carloscarrasco on 10/8/16.
 */

public interface MarvelApiInterface {

    @GET("v1/public/characters/{character_id}/comics")
    Observable<MarvelResponse> getComics(@Path("character_id") String character_id);
}
