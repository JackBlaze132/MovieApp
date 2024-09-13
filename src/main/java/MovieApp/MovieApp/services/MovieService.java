package MovieApp.MovieApp.services;

import MovieApp.MovieApp.Model.Movie;
import MovieApp.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie, int id) {
        return movieRepository.findById(id)
                .map(existingMovie -> {
                    existingMovie.setName(movie.getName());
                    existingMovie.setCategory(movie.getCategory());
                    existingMovie.setYear(movie.getYear());
                    existingMovie.setDirector(movie.getDirector());
                    existingMovie.setDuration(movie.getDuration());
                    existingMovie.setRating(movie.getRating());
                    return movieRepository.save(existingMovie);
                }).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @Override
    public boolean deleteMovie(int id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Movie> findById(int id) {
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
