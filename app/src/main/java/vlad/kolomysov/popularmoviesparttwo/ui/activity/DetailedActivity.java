package vlad.kolomysov.popularmoviesparttwo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import vlad.kolomysov.popularmoviesparttwo.App;
import vlad.kolomysov.popularmoviesparttwo.R;
import vlad.kolomysov.popularmoviesparttwo.utils.Utils;

/**
 * Copyright (C) Created by Vlad Kolomysov on 15.07.16.
 * All rights reserved. United Financial Capital Bank, Moscow
 */
public class DetailedActivity extends AppCompatActivity {

    public static final String PARAM_MOVIE = "movie";
    private boolean mTwoPane;
    private Movie mMovie;
    private View mMainCoordinatorLayoutView;

    public static Intent newIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, DetailedActivity.class);
        intent.putExtra(PARAM_MOVIE, movie);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inject dependencies
        setContentView(R.layout.activity_detail);
        ((App) getApplication()).getDaggerComponent().inject(this);
        mMainCoordinatorLayoutView = findViewById(R.id.activity_detail);

        //inject views
        ButterKnife.bind(this);
        mMovie = getIntent().getParcelableExtra(PARAM_MOVIE);

        //TODO: issue to fix now is why is the god-dman detailed fragment inflated twice when the configuration changes.
        if (Utils.isLandscape() && Utils.isTablet()) {
            mTwoPane = true;
            inflateMainFragment();
            inflateDetailFragment(mMovie);
        } else {
            if (savedInstanceState != null) {
                return;
            }
            inflateDetailFragment(mMovie);
        }
    }

    private void inflateMainFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, MainFragment.newInstance())
                .commit();
    }

    private void inflateDetailFragment(Movie movie) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container2, DetailedFragment.newInstance(movie))
                .commit();
    }
}
