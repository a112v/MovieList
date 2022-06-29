package com.example.comrestmovie.service;

import com.example.comrestmovie.dao.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.comrestmovie.entities.Movie;
import com.example.comrestmovie.entities.Reviews;

import java.util.List;

@Component
public class MovieService
{
    @Autowired
    MovieRepository MovieRepo;

    public List<Movie> AllMovie()
    {
        List<Movie> lst=this.MovieRepo.findAll();
        return lst;
    }

    public List<Movie> MoviesWithRating(int rating)
    {
        List<Movie> lst=this.MovieRepo.findByrating(rating);
        return lst;
    }

    public Movie AddMovie(Movie movie)
    {
        MovieRepo.save(movie);
        return movie;
    }

    public void RemoveMovie(int id)
    {
        List<Movie> lst=this.MovieRepo.findAll();
        Movie mvi=null;
        for(int i=0;i<lst.size();i++)
        {
           mvi=lst.get(i);
           if(mvi.getID()==id)
           {
               break;
           }
        }
        this.MovieRepo.delete(mvi);
    }

    public Movie MakeChanges(Movie movie,int id)
    {
        movie.setID(id);
        this.MovieRepo.save(movie);
        return movie;
    }
}
