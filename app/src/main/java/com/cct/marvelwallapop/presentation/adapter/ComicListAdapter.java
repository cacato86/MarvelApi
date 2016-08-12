package com.cct.marvelwallapop.presentation.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cct.marvelwallapop.R;
import com.cct.marvelwallapop.data.Comic;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class ComicListAdapter extends RecyclerView.Adapter<ComicListAdapter.ViewHolder> {

    private List<Comic> comics = new ArrayList<>();
    private onItemClick mOnItemClick;

    public void setListener(onItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.character_image)
        ImageView character_image;
        @BindView(R.id.character_name)
        TextView character_name;
        @BindView(R.id.cv)
        CardView cv;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setCharactersArray(List<Comic> comicsArray) {
        this.comics = comicsArray;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return comics.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_character_list, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Picasso.with(viewHolder.character_image.getContext())
                .load(comics.get(position).getImages().get(0).getImage())
                .into(viewHolder.character_image);
        viewHolder.character_name.setText(comics.get(position).getTitle());
        viewHolder.cv.setOnClickListener(
                view -> mOnItemClick.onItemClick(comics.get(position), viewHolder.character_image));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public interface onItemClick {
        void onItemClick(Comic comic, View view);
    }
}