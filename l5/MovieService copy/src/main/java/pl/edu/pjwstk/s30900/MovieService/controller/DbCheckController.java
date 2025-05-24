package pl.edu.pjwstk.s30900.MovieService.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbCheckController {

    private final JdbcTemplate jdbc;

    public DbCheckController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/db-check")
    public String dbCheck() {
        try {
            Integer result = jdbc.queryForObject("SELECT 1", Integer.class);
            return "Database connection OK. SELECT 1 -> " + result;
        } catch (Exception ex) {
            return "Database connection FAILED: " + ex.getMessage();
        }
    }
}
