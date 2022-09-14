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
        return new ResponseEntity<>(artistService.getAllArtists(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        return artistService.getArtistById(id).isPresent() ? new ResponseEntity<>(artistService.getArtistById(id).get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // ERROR - need to find notation for enum
    @GetMapping(value = "/genre/{genre}")
    public ResponseEntity<List<Artist>> getArtistsByGenre(@PathVariable Genre genre) {
        return new ResponseEntity<>(artistService.getArtistsByGenre(genre), HttpStatus.OK);
    }

    @GetMapping(value = "/favourites/{id}")
    public ResponseEntity<List<Artist>> getFavouriteArtistsByUserId(@PathVariable Long id){
        List<Artist> favouriteArtists = artistService.getFavouriteArtistsByUserId(id);
        if (favouriteArtists == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(favouriteArtists, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Artist> saveArtist(@RequestBody Artist artist) {
        Artist newArtist = artistService.saveArtist(artist);
        return new ResponseEntity<>(artist, HttpStatus.CREATED);
    }

    @GetMapping(value = "/search/{name}")
    public ResponseEntity<Optional<List<Artist>>> searchArtistByName(@PathVariable String name) {
        Optional<List<Artist>> artists = artistService.searchArtistByName(name);

        return artists.isPresent()? new ResponseEntity<>(artists, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeArtistById(@PathVariable long id) {
        Reply reply = artistService.removeArtistById(id);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

}
