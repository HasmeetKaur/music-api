package com.example.musicapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    public String name;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIgnoreProperties({"tracks", "albums"})
    public Artist artist;

    @Column(name = "genre")
    public Genre genre;

    @Column(name = "length")
    public double length;

    public Track(String name, Artist artist, Genre genre, double length) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.length = length;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Track() {
    }
}

