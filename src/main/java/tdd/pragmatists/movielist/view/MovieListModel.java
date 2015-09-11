package tdd.pragmatists.movielist.view;

import tdd.pragmatists.movielist.movies.Movie;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MovieListModel extends AbstractListModel<Movie> {

	private List<Movie> movies = new ArrayList<>();

	@Override
	public int getSize() {
		return movies.size();
	}

	@Override
	public Movie getElementAt(int index) {
		return movies.get(index);
	}

	public void update(List<Movie> movies) {
		this.movies = movies;
		fireAllContentsChanged();
	}

	private void fireAllContentsChanged() {
		super.fireContentsChanged(this, 0, getSize() - 1);
	}

}
