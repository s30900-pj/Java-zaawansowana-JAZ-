package pl.edu.pjwstk.s30900.MovieService.service;

import org.springframework.stereotype.Service;
import pl.edu.pjwstk.s30900.MovieService.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public MovieService() {
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

        long newId = idGenerator.incrementAndGet();
        movie.setId(newId);

        movies.add(movie);
        return movie;
    }
}
