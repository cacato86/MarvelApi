package com.cct.marvelwallapop.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cct.marvelwallapop.R;
import com.cct.marvelwallapop.data.Character;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.ViewHolder> {

    private List<Character> characters = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.character_image)
        ImageView character_image;
        @BindView(R.id.character_name)
        TextView character_name;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setCharactersArray(List<Character> charactersArray) {
        this.characters = charactersArray;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_character_list, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Picasso.with(viewHolder.character_image.getContext())
                .load(characters.get(position).getImage())
                .into(viewHolder.character_image);
        viewHolder.character_name.setText(characters.get(position).getName());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}