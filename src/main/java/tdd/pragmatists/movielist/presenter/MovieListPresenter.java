package tdd.pragmatists.movielist.presenter;

import tdd.pragmatists.movielist.db.MovieRepository;
import tdd.pragmatists.movielist.movies.Movie;
import tdd.pragmatists.movielist.view.MovieView;

public class MovieListPresenter {

    private final MovieView movieView;
    private final MovieRepository movies;

    public MovieListPresenter(MovieView movieView, MovieRepository movies) {
        this.movieView = movieView;
        this.movies = movies;
    }

    public void add() {
        Movie movie = new Movie(movieView.getNewTitle());
		movies.save(movie);
        showAll();
    }

	public void shown() {
		showAll();
	}

    private void showAll() {
        movieView.showMovies(movies.findAll());
    }

}
