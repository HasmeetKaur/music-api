package com.example.musicapi.services;

import com.example.musicapi.models.*;
import com.example.musicapi.repositories.AlbumRepository;
import com.example.musicapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    UserRepository userRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Optional<Album> getAlbumById(long id) {
        return albumRepository.findById(id);
    }

//    public Album getAlbumByTrackId(long id) {
//        Optional<Album> album = albumRepository.findByTrackId(id);
//        if (album.isEmpty()) {
//            return null;
//        } else {
//            return album.get();
//        }
//    }

    public List<Album> getAlbumsByGenre(Genre genre) {
        return albumRepository.findByGenre(genre);
    }

    public List<Album> getAlbumsByArtistId(Long id) {
        Optional<List<Album>> albums = albumRepository.findByArtistId(id);
        if (albums.isPresent()) {
            return albums.get();
        } else {
            return null;
        }
    }

    public List<Album> getFavouriteAlbumsByUserId(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return null;
        } else {
            return user.get().getFavouriteAlbums();
        }
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
        return albumRepository.findByName(name);

    }
}


