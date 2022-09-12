package com.example.musicapi.services;

import com.example.musicapi.models.Album;
import com.example.musicapi.models.Artist;
import com.example.musicapi.models.Genre;
import com.example.musicapi.repositories.AlbumRepository;
import com.example.musicapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Optional<Album> getAlbumById(long id) {
        return albumRepository.findById(id);
    }

    public List<Album> getAlbumsByGenre(Genre genre) {
        return albumRepository.findByGenre(genre);
    }

    public List<Album> getAlbumsByArtist(Artist artist) {
        return albumRepository.findByArtist(artist);
    }

    public List<Album> getFavouriteAlbumsByUserId(long id) {
        return albumRepository.findByUserId(id);
    }

    
}


