package vlad.kolomysov.popularmoviesparttwo.utils;

import javax.inject.Singleton;

import dagger.Component;
import vlad.kolomysov.popularmoviesparttwo.App;

/**
 * Copyright (C) Created by Vlad Kolomysov on 15.07.16.
 * All rights reserved. United Financial Capital Bank, Moscow
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    //Application-level
    void inject(App application);

    //Activities
    void inject(MainActivity activity);

    void inject(DetailedActivity activity);

    //Fragments
    void inject(MainFragment fragment);

    void inject(DetailedFragment fragment);

    //view
    void inject(TrailerRowView view);

    void inject(ReviewRowView view);
}
