package org.movieapp.repository;


import org.movieapp.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for the Movie entity.
 * Extends JpaRepository to provide CRUD operations for Movie objects.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>
{
    /**
     * Finds a movie by its ID.
     *
     * @param id The ID of the movie to find.
     * @return An Optional containing the movie if found, otherwise empty.
     */
    Optional<Movie> findById(int id);
}
