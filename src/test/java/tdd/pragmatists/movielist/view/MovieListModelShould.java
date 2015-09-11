package tdd.pragmatists.movielist.view;

import org.junit.Test;
import tdd.pragmatists.movielist.movies.Movie;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MovieListModelShould {

    @Test
    public void invokeListenersOnUpdate() {
        MovieListModel movieListModel = new MovieListModel();
        ListDataListener listener = mock(ListDataListener.class);
        movieListModel.addListDataListener(listener);

        movieListModel.update(new ArrayList<Movie>());

        verify(listener).contentsChanged(any(ListDataEvent.class));
    }
}
