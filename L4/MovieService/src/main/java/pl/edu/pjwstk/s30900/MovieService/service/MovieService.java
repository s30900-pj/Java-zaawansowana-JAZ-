package pl.edu.pjwstk.s30900.MovieService.service;

import org.springframework.stereotype.Service;
import pl.edu.pjwstk.s30900.MovieService.MovieRepository;
import pl.edu.pjwstk.s30900.MovieService.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service

public class MovieService{

    private final List<Movie> movies = new ArrayList<>();
    private long nextId = 3;

    public MovieService(MovieRepository movieRepository) {
        movies.add(new Movie(1L, "Matrix", "Sci-Fi", 1999, 9.0));
        movies.add(new Movie(2L, "Titanic", "Romance", 1997, 8.5));
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(Long id) {
        return movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Movie addMovie(Movie movie) {
        if (movie.getId() != null) {
            throw new IllegalArgumentException("Id should not be provided");
        }

        movie.setId(nextId++);
        movies.add(movie);
        return movie;
    }
    public Movie updateMovie(Long id, Movie incoming) {
        Movie existing = getMovieById(id);
        if (existing == null) {
            return null;
        }
        if (incoming.getId() != null && !incoming.getId().equals(id)) {
            throw new IllegalArgumentException("Id in body must be absent or equal to path id");
        }
        existing.setName(incoming.getName());
        existing.setCategory(incoming.getCategory());
        existing.setYear(incoming.getYear());
        existing.setRating(incoming.getRating());
        return existing;
    }
    public boolean deleteMovie(Long id) {
        return movies.removeIf(m -> m.getId().equals(id));
    }
}
