package com.cct.marvelwallapop.domain.net.usecase;

import com.cct.marvelwallapop.data.Comic;
import com.cct.marvelwallapop.domain.repository.RepositoryInterface;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class GetComics extends GenericUseCase {

    private String character_id;

    @Inject
    public GetComics(RepositoryInterface repository) {
        super(repository);
    }

    public void setParameters(String character_id) {
        this.character_id = character_id;

    }

    @Override
    public Observable<List<Comic>> buildUseCaseObservable() {
        return repository.getComics(character_id);
    }
}
