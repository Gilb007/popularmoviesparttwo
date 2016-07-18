package vlad.kolomysov.popularmoviesparttwo.ui.view;



import java.util.List;

import vlad.kolomysov.popularmoviesparttwo.api.models.review.Review;
import vlad.kolomysov.popularmoviesparttwo.api.models.trailer.Trailer;

/**
 * Created by Senpai on 1/6/16.
 */
public interface DetailListView extends DevilListView
{
    void showLoading();

    void hideLoading();

    void setTrailers(List<Trailer> trailers);

    void setReviews(List<Review> reviews);

    void removeTrailer(Trailer movie);

    void removeReview(Review movie);
}
