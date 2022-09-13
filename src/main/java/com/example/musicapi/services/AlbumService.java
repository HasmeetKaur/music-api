package com.example.musicapi.services;

import com.example.musicapi.models.*;
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

    public Album saveAlbum(Album album) {
        albumRepository.save(album);
        return album;
    }

    public Reply removeAlbumById(Long id) {
        Optional<Album> album = albumRepository.findById(id);
        if (album.isEmpty()) {
            return new Reply(false, "Album not found.");
        } else {
            albumRepository.delete(album.get());
            return new Reply(true, "Album successfully deleted.");
        }
    }



    public Optional<Album> searchAlbumByName(String name) {
        return albumRepository.searchAlbumByName(name);

    }
}


