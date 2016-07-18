package vlad.kolomysov.popularmoviesparttwo.ui.view;


import java.util.List;

import vlad.kolomysov.popularmoviesparttwo.api.models.movie.Movie;

/**
 * Created by Senpai on 1/6/16.
 */
public interface MovieListView extends DevilListView{

    void showLoading();

    void hideLoading();

    void setItems(List<Movie> movies);

    void remove(Movie movie);
}
