package dev.saneth.movies.controllers;

import dev.saneth.movies.entities.Movie;
import dev.saneth.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(final MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movieList = movieService.allMovies();
        return new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String id){
        Optional<Movie> movie = movieService.selectedMovie(id);
        return new ResponseEntity<Optional<Movie>>(movie,HttpStatus.OK);
    }
}
