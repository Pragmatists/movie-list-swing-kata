package tdd.pragmatists.movielist.view;

import tdd.pragmatists.movielist.movies.Movie;

import java.util.List;

public interface MovieView {

	String getNewTitle();

	void showMovies(List<Movie> movies);

	Movie getSelectedMovie();

}
