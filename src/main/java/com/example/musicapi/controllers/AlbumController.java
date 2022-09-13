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

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@RestController
@RequestMapping(value = "/albums")
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
        return albumService.getAlbumById(id).isPresent() ? new ResponseEntity<>(albumService.getAlbumById(id).get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/track/{id}")
    public ResponseEntity<Album> getAlbumByTrackId(@PathVariable Long id) {
        Album album = albumService.getAlbumByTrackId(id);
        return album != null ? new ResponseEntity<>(album, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/genre")
    public ResponseEntity<List<Album>> getAlbumsByGenre(@PathVariable Genre genre){
        List<Album> albums = albumService.getAlbumsByGenre(genre);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping(value = "/artist/{id}")
    public ResponseEntity<List<Album>> getAlbumsByArtistId(@PathVariable long id){
        List<Album> albums = albumService.getAlbumsByArtistId(id);
        return albums != null ? new ResponseEntity<>(albums, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{userId}/favourites")
    public ResponseEntity<List<Album>> getFavouriteAlbumsByUserId(@PathVariable Long id){
        List<Album> albums = albumService.getFavouriteAlbumsByUserId(id);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Album> saveAlbum(@RequestBody Album album) {
        Album newAlbum = albumService.saveAlbum(album);
        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

    @GetMapping(value = "/search/{name}")
    public ResponseEntity<Optional<Album>> searchAlbumByName(@PathVariable String name) {
        Optional<Album> album = albumService.searchAlbumByName(name);
        return album.isPresent()? new ResponseEntity<>(album, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeAlbumById(@PathVariable long id) {
        Reply reply = albumService.removeAlbumById(id);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

}
