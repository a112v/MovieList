package com.example.comrestmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.comrestmovie.entities.Movie;
import com.example.comrestmovie.service.MovieService;

import javax.validation.Valid;
import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieController
{
    @Autowired
    MovieService movieservice;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> GetAllMovies()
    {
        List<Movie> lst=this.movieservice.AllMovie();
        if(lst.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(lst));
    }

    @GetMapping("/movies/{rating}")
    public ResponseEntity<List<Movie>> GetMoviesByRating(@PathVariable("rating")int rating)
    {
        List<Movie> lst=this.movieservice.MoviesWithRating(rating);
        if(lst.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(lst));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> AddNewMovie(@Valid @RequestBody Movie movie) {
        Movie NewMovie = null;

        try {
            NewMovie = this.movieservice.AddMovie(movie);
            return ResponseEntity.of(Optional.of(movie));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/movies/{MovieID}")
    public ResponseEntity<?> DeleteMovie(@PathVariable("MovieID")int ID) {
        try {
            this.movieservice.RemoveMovie(ID);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("movies/{id}")
    public ResponseEntity<Movie> UpdateMovie(@PathVariable("id")int id,@RequestBody Movie movie)
    {
        try
        {
            Movie UpdatedMovie=this.movieservice.MakeChanges(movie,id);
            return ResponseEntity.of(Optional.of(UpdatedMovie));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
