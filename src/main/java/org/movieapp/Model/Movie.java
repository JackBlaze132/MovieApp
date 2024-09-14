package org.movieapp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Entity representing a movie.
 */
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Movie {

    /**
     * The unique identifier for the movie.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The name of the movie.
     */
    @Column(name = "name")
    private String name;

    /**
     * The category or genre of the movie.
     */
    @Column(name = "category")
    private String category;

    /**
     * The release year of the movie.
     */
    @Column(name = "year")
    private int year;

    /**
     * The director of the movie.
     */
    @Column(name = "director")
    private String director;

    /**
     * The duration of the movie in minutes.
     */
    @Column(name = "duration")
    private int duration; // Duration in minutes

    /**
     * The rating of the movie.
     */
    @Column(name = "rating")
    private double rating;
}
