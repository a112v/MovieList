package com.example.comrestmovie.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.comrestmovie.entities.Movie;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie,Integer> {

    @Query(value="Select * from movies",nativeQuery = true)
    public List<Movie> findAll();

    @Query(value="select * from movies where rating =:r",nativeQuery = true)
    public List<Movie> findByrating(@Param("r") int rating);

}
