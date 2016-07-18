package vlad.kolomysov.popularmoviesparttwo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.bgirlogic.movies.R;

import vlad.kolomysov.popularmoviesparttwo.App;

import vlad.kolomysov.popularmoviesparttwo.api.models.movie.Movie;
import vlad.kolomysov.popularmoviesparttwo.ui.fragment.DetailedFragment;
import vlad.kolomysov.popularmoviesparttwo.ui.fragment.MainFragment;
import vlad.kolomysov.popularmoviesparttwo.utils.Utils;

/**
 * Copyright (C) Created by Vlad Kolomysov on 15.07.16.
 * All rights reserved. United Financial Capital Bank, Moscow
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private View mMainCoordinatorLayoutView;

    private boolean mTwoPane;

    private Movie mMovie;

    private MainFragment mainFragment;

    private DetailedFragment detailedFragment;

    private final String SIMPLE_FRAGMENT_TAG = "myfragmenttag";

    private final String SIMPLE_FRAGMENT_TAG_MAIN = "main";


    public static Intent newIntentForDetailedFragment(Context context, Movie movie) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(DetailedActivity.PARAM_MOVIE, movie);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mMainCoordinatorLayoutView = findViewById(R.id.activity_base);

        ((App) getApplication()).getDaggerComponent().inject(this);

        if (Utils.isLandscape() && Utils.isTablet()) {
            boolean land = Utils.isLandscape();
            boolean tab = Utils.isTablet();
            mTwoPane = true;
            if (savedInstanceState != null) {
                return;
            }
            inflateMainFragment();

            mMovie = getIntent().getParcelableExtra(DetailedActivity.PARAM_MOVIE);
            inflateDetailFragment(mMovie);

        } else {
            inflateMainFragment();
        }
    }


    protected int getContainerId() {
        return R.id.container;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    private void inflateMainFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(getContainerId(), MainFragment.newInstance())
                .addToBackStack(SIMPLE_FRAGMENT_TAG_MAIN)
                .commit();
    }


    private void inflateDetailFragment(Movie movie) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container2, DetailedFragment.newInstance(movie))
                .addToBackStack(SIMPLE_FRAGMENT_TAG)
                .commit();
    }


}
