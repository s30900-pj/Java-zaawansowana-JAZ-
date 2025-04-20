package pl.edu.pjwstk.s30900.MovieService.model;

public class Movie {

    private Long id;
    private String name;
    private String category;
    private int year;
    private double rating;

    public Movie() {
    }

    public Movie(Long id, String name, String category, int year, double rating) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.year = year;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
}