package tdd.pragmatists.movielist;

import tdd.pragmatists.movielist.view.SwingMovieList;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainApplicationFrame extends JFrame {

	public MainApplicationFrame(SwingMovieList swingMovieList) {
		super("Movie List");
		add(swingMovieList);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
	}
}
