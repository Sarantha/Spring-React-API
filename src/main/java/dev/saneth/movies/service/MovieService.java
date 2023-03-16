package dev.saneth.movies.service;

import dev.saneth.movies.entities.Movie;
import dev.saneth.movies.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(final MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> selectedMovie(String id){
        return movieRepository.findByImdbId(id);
    }
}
