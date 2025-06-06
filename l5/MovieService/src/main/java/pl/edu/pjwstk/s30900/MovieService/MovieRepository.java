package pl.edu.pjwstk.s30900.MovieService;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjwstk.s30900.MovieService.model.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllBy();
}
