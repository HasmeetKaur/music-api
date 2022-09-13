package com.example.musicapi.controllers;

import com.example.musicapi.models.*;
import com.example.musicapi.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/artists")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists(){
        return new ResponseEntity<>(artistService.getAllArtist(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable long id) {
        return artistService.getArtistById(id).isPresent() ? new ResponseEntity<>(artistService.getArtistById(id).get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // ERROR - need to find notation for enum
    @GetMapping(value = "/{genre}")
    public ResponseEntity<List<Artist>> getArtistByGenre(@PathVariable Genre genre) {
        return artistService.equals(getArtistByGenre(genre)) ? new ResponseEntity<>(artistService.getArtistByGenre(genre), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getFavouriteArtistByUserId(@PathVariable Long id){
        return artistService.equals(getFavouriteArtistByUserId(id)) ? new ResponseEntity<>(artistService.getFavouriteArtistsByUserId(id), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Artist> saveArtist(@RequestBody Artist artist) {
        Artist newArtist = artistService.saveArtist(artist);
        return new ResponseEntity<>(artist, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Optional<Artist>> searchArtistByName(@RequestBody String name) {
        Optional<Artist> artist = artistService.searchArtistByName(name);
        return new ResponseEntity<>(artist, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/artists/{artistsId}")
    public ResponseEntity<String> removeArtistById(@PathVariable long artistId) {
        Reply reply = artistService.removeArtistById(artistId);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

}
