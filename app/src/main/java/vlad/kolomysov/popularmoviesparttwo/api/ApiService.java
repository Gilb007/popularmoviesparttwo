package vlad.kolomysov.popularmoviesparttwo.api;

import android.graphics.Movie;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;
import vlad.kolomysov.popularmoviesparttwo.api.movie.Movies;
import vlad.kolomysov.popularmoviesparttwo.api.review.Reviews;
import vlad.kolomysov.popularmoviesparttwo.api.trailer.Trailers;

/**
 * Copyright (C) Created by Vlad Kolomysov on 15.07.16.
 * All rights reserved. United Financial Capital Bank, Moscow
 */
public interface ApiService {

    //http://api.themoviedb.org/3/discover/movie?sort_by=popularity_desc&api_key=8df5a981e3421ec1fe8fb26bc13e368b
    @GET(Constants.API_ADDRESS_ENDPOINT_MOVIES)
    Observable<Movies> getMovies(@Query("sort_by") String sortBy);

    //http://api.themoviedb.org/3/movie/23800?api_key=8df5a981e3421ec1fe8fb26bc13e368b
    @GET(Constants.API_ADDRESS_ENDPOINT_DETAILS)
    Observable<Movie> getMovieDetails(@Path("id") String id);

    //http://api.themoviedb.org/3/movie/500/videos?api_key=8df5a981e3421ec1fe8fb26bc13e368b
    @GET(Constants.API_ADDRESS_ENDPOINT_TRAILERS)
    Observable<Trailers> getTrailers(@Path("id") String id);

    //http://api.themoviedb.org/3/movie/49026/reviews?api_key=8df5a981e3421ec1fe8fb26bc13e368b
    @GET(Constants.API_ADDRESS_ENDPOINT_REVIEWS)
    Observable<Reviews> getReviews(@Path("id") String id);
}
