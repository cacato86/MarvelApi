package com.cct.marvelwallapop.presentation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cct.marvelwallapop.R;
import com.cct.marvelwallapop.data.Comic;
import com.cct.marvelwallapop.data.Image;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class ComicDetail extends AppCompatActivity {

    @BindView(R.id.comic_title)
    protected TextView comic_title;
    @BindView(R.id.comic_description)
    protected TextView comic_description;
    @BindView(R.id.comic_image)
    protected ImageView comic_image;
    @BindView(R.id.toolbar_detail)
    protected Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    protected CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Comic comic = (Comic) bundle.getSerializable("comic");
            createToolbar(comic.getTitle());
            fillComic(comic);
        } else {
            Toast.makeText(this, "We have a litlle problem :(", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void createToolbar(String titleToolbar) {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        collapsingToolbarLayout.setTitle(titleToolbar);
    }

    private void fillComic(Comic comic) {
        comic_title.setText(comic.getTitle());
        comic_description.setText(comic.getDescription());
        Picasso.with(this)
                .load(generateRandomImage(comic.getImages()))
                .into(comic_image);
    }

    private String generateRandomImage(List<Image> images) {
        Random r = new Random();
        int random = r.nextInt(images.size());
        return images.get(random).getImage();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}

