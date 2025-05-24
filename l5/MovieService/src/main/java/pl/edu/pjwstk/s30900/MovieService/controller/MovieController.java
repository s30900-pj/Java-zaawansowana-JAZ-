package pl.edu.pjwstk.s30900.MovieService.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pjwstk.s30900.MovieService.model.Movie;
import pl.edu.pjwstk.s30900.MovieService.service.MovieService;


import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movie> all() {
        return service.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie one(@PathVariable Long id) {
        Movie m = service.getMovieById(id);
        if (m == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return m;
    }

    @PostMapping
    public Movie add(@RequestBody Movie payload) {
        try {
            return service.addMovie(payload);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id,
                        @RequestBody Movie payload) {

        try {
            Movie updated = service.updateMovie(id, payload);
            if (updated == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return updated;
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!service.deleteMovie(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}/available")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void markAvailable(@PathVariable Long id) {
        if (!service.setAvailable(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}