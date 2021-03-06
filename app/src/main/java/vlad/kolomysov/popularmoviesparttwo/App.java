package vlad.kolomysov.popularmoviesparttwo;

import android.app.Application;

import com.facebook.stetho.Stetho;

import vlad.kolomysov.popularmoviesparttwo.utils.AppComponent;
import vlad.kolomysov.popularmoviesparttwo.utils.AppModule;
import vlad.kolomysov.popularmoviesparttwo.utils.DaggerAppComponent;

/**
 * Copyright (C) Created by Vlad Kolomysov on 15.07.16.
 * All rights reserved. United Financial Capital Bank, Moscow
 */
public class App extends Application {

    public static final String TAG = App.class.getSimpleName();

    private static App sInstance;

    /**
     * Dagger component for the application
     */

    private AppComponent appComponent;

    public App() {
        sInstance = this;
    }

    public static App getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Stetho.initializeWithDefaults(this);
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public AppComponent getDaggerComponent() {
        return appComponent;
    }
}
