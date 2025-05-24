package pl.edu.pjwstk.s30900.MovieService.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    /* ---------- kolumny ---------- */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // AUTO_INCREMENT
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    private Integer year;
    private Double  rating;

    @Column(nullable = false)
    private boolean isAvailable = false;                  // domyślnie false

    /* ---------- konstruktory ---------- */

    public Movie() { }

    public Movie(String name, String category,
                 Integer year, Double rating, boolean isAvailable) {

        this.name        = name;
        this.category    = category;
        this.year        = year;
        this.rating      = rating;
        this.isAvailable = isAvailable;
    }

    /* ---------- gettery / settery ---------- */

    public Long     getId()                { return id; }
    public void     setId(Long id)         { this.id = id; }

    public String   getName()              { return name; }
    public void     setName(String name)   { this.name = name; }

    public String   getCategory()          { return category; }
    public void     setCategory(String c)  { this.category = c; }

    public Integer  getYear()              { return year; }
    public void     setYear(Integer year)  { this.year = year; }

    public Double   getRating()            { return rating; }
    public void     setRating(Double r)    { this.rating = r; }

    public boolean  isAvailable()          { return isAvailable; }
    public void     setAvailable(boolean a){ this.isAvailable = a; }
}