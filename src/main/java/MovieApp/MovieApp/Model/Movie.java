package MovieApp.MovieApp.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "year")
    private int year;

    @Column(name = "director")
    private String director;

    @Column(name = "duration")
    private int duration; // Duration in minutes

    @Column(name = "rating")
    private double rating;
}
