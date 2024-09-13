package MovieApp.MovieApp.services;

import MovieApp.MovieApp.Model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    Movie addMovie(Movie movie);
    Movie updateMovie(Movie movie, int id);
    boolean deleteMovie(int id);
    Optional<Movie> findById(int id);

    List<Movie> getAllMovies();
}
