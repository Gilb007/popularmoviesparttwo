package vlad.kolomysov.popularmoviesparttwo.utils;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (C) Created by Vlad Kolomysov on 15.07.16.
 * All rights reserved. United Financial Capital Bank, Moscow
 */
@Module
public class AppModule {

    private final Context appContext;

    public AppModule(Application application) {
        this.appContext = application.getApplicationContext();
    }

    @Provides
    public Context provideApplicationContext() {
        return appContext;
    }
}
