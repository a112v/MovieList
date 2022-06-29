package com.example.comrestmovie.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Reviews
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private int id;

    @NotBlank
    @Size(min=5,message = "atleast 5 characters should be there")
    private String about;

    @Pattern(regexp ="([0-9]+)%",message = "enter percentage")
    private String RottenTomatoes;

    public Reviews(){};
    public Reviews(int Id,String About,String rottenTomatoes)
    {
        this.id=Id;
        this.about=About;
        this.RottenTomatoes=rottenTomatoes;
    }

    public int getId() {
        return id;
    }

    public String getAbout() {
        return about;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", about='" + about + '\'' +
                ", RottenTomatoes=" + RottenTomatoes +
                '}';
    }

    public String getRottenTomatoes() {
        return RottenTomatoes;
    }

    public void setRottenTomatoes(String rottenTomatoes) {
        RottenTomatoes = rottenTomatoes;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setId(int id) {
        this.id = id;
    }


}
