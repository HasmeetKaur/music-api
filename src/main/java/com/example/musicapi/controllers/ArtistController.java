package com.example.musicapi.controllers;

import com.example.musicapi.models.Artist;
import com.example.musicapi.models.Genre;
import com.example.musicapi.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/artists")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Genre> genre
    ){
        List<Artist> artists;
        if(()){
            artists = artistService.getAllArtists();
        } else if{
            artists = artistService.getArtistsById();
        } else if {
            artists = artistService.getArtistsByGenre();
        } else if {
            artists = artistService.getFavouriteArtistsByUserId();
        }
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

}
