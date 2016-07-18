package vlad.kolomysov.popularmoviesparttwo.ui.presenter;

import vlad.kolomysov.popularmoviesparttwo.ui.view.DevilListView;

/**
 * Copyright (C) Created by Vlad Kolomysov on 15.07.16.
 * All rights reserved. United Financial Capital Bank, Moscow
 */
public interface Presenter<T extends DevilListView> {

    void initialize();

    void onViewCreate();

    void onViewResume();

    void onViewDestroy();

    void setView(T view);

    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}
