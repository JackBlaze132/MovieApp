package org.movieapp.services;

import org.movieapp.Model.Movie;

import java.util.List;
import java.util.Optional;

/**
 * Interface for the movie service, defining the methods for movie operations.
 */
public interface IMovieService {

    /**
     * Adds a new movie to the database.
     *
     * @param movie The movie to add.
     * @return The newly added movie.
     */
    Movie addMovie(Movie movie);

    /**
     * Updates an existing movie by its ID.
     *
     * @param movie The updated movie data.
     * @param id The ID of the movie to update.
     * @return The updated movie.
     */
    Movie updateMovie(Movie movie, int id);

    /**
     * Deletes a movie by its ID.
     *
     * @param id The ID of the movie to delete.
     * @return true if the movie was deleted, otherwise false.
     */
    boolean deleteMovie(int id);

    /**
     * Finds a movie by its ID.
     *
     * @param id The ID of the movie to find.
     * @return An Optional containing the movie if found, otherwise empty.
     */
    Optional<Movie> findById(int id);

    /**
     * Retrieves all movies from the database.
     *
     * @return A list of all movies.
     */
    List<Movie> getAllMovies();
}
