package com.service.imdb;

public class Movie {
    
    protected String title;
    protected String urlImage;
    protected Double rating;
    protected int year;


    public Movie(String title, String urlImage, Double rating, int year) {
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
    }


    @Override
    public String toString() {
        return (this.title + " with rating " + this.rating + " released in " + this.year);
    }

}
