package com.cct.marvelwallapop.domain.repository;

import com.cct.marvelwallapop.data.Comic;

import java.util.List;

import rx.Observable;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public interface RepositoryInterface {
    Observable<List<Comic>> getComics(String character_id);
}
