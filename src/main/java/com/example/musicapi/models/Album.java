package com.example.musicapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIgnoreProperties({"albums", "tracks"})
    private Artist artist;

    @Column(name = "year")
    private int year;

    @Column(name = "genre")
    private Genre genre;

    @OneToMany
    @JoinColumn(name = "album_id")
    private List<Track> tracks;

    public Album(String name, Artist artist, int year, Genre genre){
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public Album(){

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }


}
