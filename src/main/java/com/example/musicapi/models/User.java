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

    @ManyToMany
    @JoinTable(
            name = "favourite_albums",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "album_id", nullable = false)}
    )
    @JsonIgnoreProperties({"users"})
    private List<Album> favouriteAlbums;

    @ManyToMany
    @JoinTable(
            name = "favourite_artists",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "artist_id", nullable = false)}
    )
    @JsonIgnoreProperties({"users"})
    private List<Artist> favouriteArtists;

    @ManyToMany
    @JoinTable(
            name = "favourite_tracks",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "track_id", nullable = false)}
    )
    @JsonIgnoreProperties({"users"})
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
