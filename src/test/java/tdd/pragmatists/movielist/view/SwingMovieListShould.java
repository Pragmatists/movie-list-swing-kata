package tdd.pragmatists.movielist.view;

import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.testing.FestSwingTestCaseTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tdd.pragmatists.movielist.MainApplicationFrame;
import tdd.pragmatists.movielist.presenter.MovieListPresenter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SwingMovieListShould extends FestSwingTestCaseTemplate {

    private FrameFixture window;
    private MovieListPresenter movieListPresenter = mock(MovieListPresenter.class);

    @Before
    public void onSetUp() {
        setUpRobot();
        MainApplicationFrame frame = createMainApplicationFramInSwingThread();
        window = new FrameFixture(robot(), frame);
        window.show();
    }

    private MainApplicationFrame createMainApplicationFramInSwingThread() {
        return GuiActionRunner
                .execute(new GuiQuery<MainApplicationFrame>() {
                    @Override
                    protected MainApplicationFrame executeInEDT() {
                        return new MainApplicationFrame(createSwingMovieList());
                    }
                });
    }

    private SwingMovieList createSwingMovieList() {
        SwingMovieList swingMovieList = new SwingMovieList();
        swingMovieList.observeWith(movieListPresenter);
        return swingMovieList;
    }

    @After
    public void after() {
        cleanUp();
    }

    @Test
    public void notifyPresenterOnAdd() {
        window.button("Add").click();

        verify(movieListPresenter).add();
    }

}
