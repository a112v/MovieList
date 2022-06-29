package com.example.comrestmovie.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.awt.image.TileObserver;

@Entity
@Table(name = "Movies")
public class Movie
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private int ID;

    @NotBlank(message = "it cant be empty")
    private String Title;

    @OneToOne(cascade = CascadeType.ALL)
    private Reviews Review;

    @Min(1)
    @Max(10)
    private int Rating;

    public Movie (int ID,String Title,Reviews Review,int Rating)
    {
        this.ID=ID;
        this.Title= Title;
        this.Review=Review;
        this.Rating=Rating;
    }
    public Movie(){};
    public int getID() {
        return ID;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public Reviews getReview() {
        return Review;
    }

    public void setReview(Reviews review) {
        Review = review;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Review='" + Review + '\'' +
                ", Rating=" + Rating +
                '}';
    }
}
