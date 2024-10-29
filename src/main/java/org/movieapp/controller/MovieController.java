package org.movieapp.controller;


import org.movieapp.Model.Movie;
import org.movieapp.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller that handles requests related to movies.
 * Provides endpoints for retrieving, adding, updating, and deleting movies.
 */
@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class MovieController {

    @Autowired
    private IMovieService movieService;

    /**
     * Retrieves all movies from the database.
     *
     * @return ResponseEntity containing a list of all movies and HTTP status OK.
     */

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id The ID of the movie to retrieve.
     * @return ResponseEntity containing the movie and HTTP status OK if found, otherwise HTTP status Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Optional<Movie> movie = movieService.findById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Adds a new movie to the database.
     *
     * @param movie The movie to add.
     * @return ResponseEntity containing the newly created movie and HTTP status Created.
     */
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie newMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    /**
     * Updates an existing movie by its ID.
     *
     * @param movie The movie data to update.
     * @param id The ID of the movie to update.
     * @return ResponseEntity containing the updated movie and HTTP status OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable int id) {
        Movie updatedMovie = movieService.updateMovie(movie, id);
        return ResponseEntity.ok(updatedMovie);
    }

    /**
     * Deletes a movie by its ID.
     *
     * @param id The ID of the movie to delete.
     * @return ResponseEntity with HTTP status OK if the movie was deleted, otherwise HTTP status Not Found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        boolean isDeleted = movieService.deleteMovie(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
