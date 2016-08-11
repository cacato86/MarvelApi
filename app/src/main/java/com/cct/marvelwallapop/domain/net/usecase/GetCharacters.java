package com.cct.marvelwallapop.domain.net.usecase;

import com.cct.marvelwallapop.data.Character;
import com.cct.marvelwallapop.domain.repository.RepositoryInterface;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class GetCharacters extends GenericUseCase {

    @Inject
    public GetCharacters(RepositoryInterface repository) {
        super(repository);
    }

    @Override
    public Observable<List<Character>> buildUseCaseObservable() {
        return repository.getCharacters();
    }
}
