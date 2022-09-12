package com.example.musicapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    private String userName;
    
    @OneToMany
    @JoinColumn(name = "album_id")
    private List<Album> favouriteAlbums;

    @OneToMany
    @JoinColumn(name = "artist_id")
    private List<Artist> favouriteArtists;

    @OneToMany
    @JoinColumn(name = "track_id")
    private List<Track> favouriteTracks;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private List<Playlist> playlists;

    public User(String userName) {
        this.userName = userName;
        this.favouriteAlbums = new ArrayList<>();
        this.favouriteArtists = new ArrayList<>();
        this.favouriteTracks = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Album> getFavouriteAlbums() {
        return favouriteAlbums;
    }

    public void setFavouriteAlbums(List<Album> favouriteAlbums) {
        this.favouriteAlbums = favouriteAlbums;
    }

    public List<Artist> getFavouriteArtists() {
        return favouriteArtists;
    }

    public void setFavouriteArtists(List<Artist> favouriteArtists) {
        this.favouriteArtists = favouriteArtists;
    }

    public List<Track> getFavouriteTracks() {
        return favouriteTracks;
    }

    public void setFavouriteTracks(List<Track> favouriteTracks) {
        this.favouriteTracks = favouriteTracks;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
