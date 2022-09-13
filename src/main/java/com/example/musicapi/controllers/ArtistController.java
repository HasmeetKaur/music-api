package com.example.musicapi.controllers;

import com.example.musicapi.models.Artist;
import com.example.musicapi.models.Genre;
import com.example.musicapi.models.Reply;
import com.example.musicapi.models.User;
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
    public ResponseEntity<Artist> getArtistByGenre(@PathVariable Genre genre) {
        return artistService.equals(getArtistByGenre(genre)) ? new ResponseEntity<>(artistService.getArtistByGenre(genre).get(artist), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }



}
