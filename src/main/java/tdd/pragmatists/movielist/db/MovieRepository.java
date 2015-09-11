package tdd.pragmatists.movielist.db;

import org.springframework.data.jpa.repository.JpaRepository;
import tdd.pragmatists.movielist.movies.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String>{

	List<Movie> findByName(String name);
	
}
