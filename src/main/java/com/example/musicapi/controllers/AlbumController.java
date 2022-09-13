package com.example.musicapi.controllers;

import com.example.musicapi.models.*;
import com.example.musicapi.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/games")
public class AlbumController {

    @Autowired
    AlbumService albumService;


    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums(){
        List<Album> albums = albumService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id){
        Optional<Album> album = albumService.getAlbumById(id);
        if (album.isPresent()){
            return new ResponseEntity<>(album.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAlbumsByGenre(@PathVariable Genre genre){
        List<Album> albums = albumService.getAlbumsByGenre(genre);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAlbumsByArtist(@PathVariable Artist artist){
        List<Album> albums = albumService.getAlbumsByArtist(artist);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Album>> getFavouriteAlbumsByUserId(@PathVariable Long id){
        List<Album> albums = albumService.getFavouriteAlbumsByUserId(id);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Album> saveAlbum(@RequestBody Album album) {
        Album newAlbum = albumService.saveAlbum(album);
        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Optional<Album>> searchAlbumByName(@RequestBody String name) {
        Optional<Album> album = albumService.searchAlbumByName(name);
        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{userId}/albums/{albumId}")
    public ResponseEntity<String> removeAlbumById(@PathVariable long albumId) {
        Reply reply = albumService.removeAlbumById(albumId);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

}
