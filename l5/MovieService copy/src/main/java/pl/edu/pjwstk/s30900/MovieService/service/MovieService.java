package pl.edu.pjwstk.s30900.MovieService.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pjwstk.s30900.MovieService.MovieRepository;
import pl.edu.pjwstk.s30900.MovieService.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService {

    private final MovieRepository repo;

    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }


    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return repo.findById(id);
    }

    public Movie addMovie(Movie movie) {
        if (movie.getId() != null) {
            throw new IllegalArgumentException("Id should not be provided on POST");
        }
        return repo.save(movie);
    }

    public Optional<Movie> updateMovie(Long id, Movie data) {
        return repo.findById(id).map(existing -> {
            existing.setName(data.getName());
            existing.setCategory(data.getCategory());
            existing.setYear(data.getYear());
            existing.setRating(data.getRating());
            return repo.save(existing);
        });
    }

    public boolean deleteMovie(Long id) {
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}