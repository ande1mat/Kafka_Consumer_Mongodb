package com.springkafka.service;

public class Movie extends Item implements Roundable{

    public Movie(String type, Integer inventory) {
        super(type, inventory);
    }

    private String rating;
    private String director;

    public Movie() {
        super();
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rating='" + rating + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
