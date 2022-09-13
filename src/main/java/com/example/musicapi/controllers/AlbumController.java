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

    @GetMapping
    public ResponseEntity<List<Album>> getAlbumsByGenre(@PathVariable Genre genre){
        return albumService.equals(getAlbumsByGenre(genre)) ? new ResponseEntity<>(albumService.getAlbumsByGenre(genre), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAlbumsByArtist(@PathVariable Artist artist){
        return albumService.equals(getAlbumsByArtist(artist)) ? new ResponseEntity<>(albumService.getAlbumsByArtist(artist), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Album>> getFavouriteAlbumsByUserId(@PathVariable Long id){
        return albumService.equals(getFavouriteAlbumsByUserId(id)) ? new ResponseEntity<>(albumService.getFavouriteAlbumsByUserId(id), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
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

    @DeleteMapping(value = "/albums/{albumId}")
    public ResponseEntity<String> removeAlbumById(@PathVariable long albumId) {
        Reply reply = albumService.removeAlbumById(albumId);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

}
