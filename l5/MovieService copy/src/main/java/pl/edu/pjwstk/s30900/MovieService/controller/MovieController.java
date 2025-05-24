package pl.edu.pjwstk.s30900.MovieService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pjwstk.s30900.MovieService.MovieRepository;
import pl.edu.pjwstk.s30900.MovieService.model.Movie;
import pl.edu.pjwstk.s30900.MovieService.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository repo;

    public MovieController(MovieRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Movie> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Movie one(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /* ---------- POST /movies ---------- */
    @PostMapping
    public Movie add(@RequestBody Movie m) {
        if (m.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "id should be null when creating");
        }
        return repo.save(m);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie payload) {

        return repo.findById(id).map(existing -> {
            existing.setName(payload.getName());
            existing.setCategory(payload.getCategory());
            existing.setYear(payload.getYear());
            existing.setRating(payload.getRating());
            return repo.save(existing);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repo.deleteById(id);
    }
}