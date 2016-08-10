package com.cct.marvelwallapop.domain.repository;

import com.cct.marvelwallapop.data.Character;

import rx.Observable;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public interface RepositoryInterface {
    Observable<Character> getCharacters();
}
