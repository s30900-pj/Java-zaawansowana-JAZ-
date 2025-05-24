package pl.edu.pjwstk.s30900.MovieService.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.s30900.MovieService.MovieRepository;
import pl.edu.pjwstk.s30900.MovieService.model.Movie;


import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repo;

    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    public List<Movie> getAllMovies() {
        return repo.findAllBy();
    }

    public Movie getMovieById(Long id) {
        try {
            return repo.getReferenceById(id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Movie addMovie(Movie movie) {
        if (movie.getId() != null)
            throw new IllegalArgumentException("id should not be provided on POST");
        return repo.save(movie);
    }

    public Movie updateMovie(Long id, Movie dto) {
        Movie existing = getMovieById(id);
        if (existing == null) return null;

        existing.setName(dto.getName());
        existing.setCategory(dto.getCategory());
        existing.setYear(dto.getYear());
        existing.setRating(dto.getRating());
        return repo.save(existing);
    }

    public boolean deleteMovie(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }

    public boolean setAvailable(Long id) {
        Movie m = getMovieById(id);
        if (m == null) return false;
        m.setAvailable(true);
        repo.save(m);
        return true;
    }
}