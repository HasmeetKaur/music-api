package com.example.musicapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //properties
    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private Genre genre;

    @OneToMany(mappedBy = "artist")
    @JsonIgnoreProperties({"artist"})
    private List<Album> albums;

    @OneToMany(mappedBy = "artist")
    @JsonIgnoreProperties({"artist"})
    private List<Track> tracks;

    //instantiation
    public Artist(String name, Genre genre){
        this.name = name;
        this.genre = genre;
        this.albums = new ArrayList<>();
        this.tracks = new ArrayList<>();
    }

    // empty constructor
    private Artist(){

    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
