package pl.edu.pjwstk.s30900.MovieService.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    private Integer year;
    private Double rating;

    public Movie() {}

    public Movie(String name, String category,
                 Integer year, Double rating) {
        this.name = name;
        this.category = category;
        this.year = year;
        this.rating = rating;
    }

    public Long getId()               { return id; }
    public void setId(Long id)        { this.id = id; }

    public String getName()           { return name; }
    public void setName(String name)  { this.name = name; }

    public String getCategory()       { return category; }
    public void setCategory(String category){ this.category = category; }

    public Integer getYear()          { return year; }
    public void setYear(Integer year) { this.year = year; }

    public Double getRating()         { return rating; }
    public void setRating(Double rating){ this.rating = rating; }
}