package org.movieapp.services;

import org.movieapp.Model.Movie;
import org.movieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the movie service interface, providing the logic for movie operations.
 */
@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Adds a new movie to the database.
     *
     * @param movie The movie to add.
     * @return The newly added movie.
     */
    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * Updates an existing movie by its ID.
     *
     * @param movie The updated movie data.
     * @param id The ID of the movie to update.
     * @return The updated movie.
     */
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

    /**
     * Deletes a movie by its ID.
     *
     * @param id The ID of the movie to delete.
     * @return true if the movie was deleted, otherwise false.
     */
    @Override
    public boolean deleteMovie(int id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Finds a movie by its ID.
     *
     * @param id The ID of the movie to find.
     * @return An Optional containing the movie if found, otherwise empty.
     */
    @Override
    public Optional<Movie> findById(int id) {
        return movieRepository.findById(id);
    }

    /**
     * Retrieves all movies from the database.
     *
     * @return A list of all movies.
     */
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
