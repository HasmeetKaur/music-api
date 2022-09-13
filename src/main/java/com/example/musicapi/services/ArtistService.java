package com.example.musicapi.services;

import com.example.musicapi.models.Artist;
import com.example.musicapi.models.Genre;
import com.example.musicapi.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    public List<Artist> getAllArtist() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtistById(long id) {
        return artistRepository.findById(id);
    }

    public List<Artist> getArtistByGenre(Genre genre) {
        return artistRepository.findByGenre(genre);
    }

    public List<Artist> getFavouriteArtistByUserId(long id) {
        return artistRepository.findFavouriteArtistByUserId(id);
    }

    public List<Artist> saveArtist(Artist artist) {
        return artistRepository.saveArtist(artist);
    }

    public Optional<Artist> removeArtistById(long id) {
        return artistRepository.removeArtistById(id);
    }

    public Optional<Artist> searchArtistByName(String name) {
        return artistRepository.searchArtistByName(name);
    }
}
