package com.cct.marvelwallapop.presentation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cct.marvelwallapop.R;
import com.cct.marvelwallapop.data.Character;
import com.cct.marvelwallapop.di.InjectorHelper;
import com.cct.marvelwallapop.domain.net.GenericSubscriber;
import com.cct.marvelwallapop.domain.net.usecase.GetCharacters;
import com.cct.marvelwallapop.presentation.adapter.CharacterListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class CharacterList extends AppCompatActivity {

    @BindView(R.id.recycleview)
    RecyclerView recycleView;

    @Inject
    GetCharacters getCharacters;

    private CharacterListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);
        ButterKnife.bind(this);
        InjectorHelper.getApplicationComponent().inject(this);

        recycleView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recycleView.setLayoutManager(llm);
        //Dagger
        adapter = new CharacterListAdapter();
        recycleView.setAdapter(adapter);

        getData();

    }

    private void getData() {
        getCharacters.subscribe(new GenericSubscriber<List<Character>>() {
            @Override
            public void onNext(List<Character> characters) {
                adapter.setCharactersArray(characters);
            }
        });
    }
}
