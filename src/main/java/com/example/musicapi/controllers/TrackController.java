package com.example.musicapi.controllers;

import com.example.musicapi.models.*;
import com.example.musicapi.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tracks")
public class TrackController {

    @Autowired
    TrackService trackService;

    @GetMapping
    public ResponseEntity<List<Track>> getAllTracks(){
        List<Track> tracks = trackService.getAllTracks();
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable Long id){
        Optional<Track> track = trackService.getTrackById(id);
        if (track.isPresent()){
            return new ResponseEntity<>(track.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Track>> getAlbumsByGenre(@PathVariable Genre genre){
        List<Track> tracks = trackService.getTracksByGenre(genre);
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Track>> getTracksByArtist(@PathVariable Artist artist){
        List<Track> tracks = trackService.getTracksByArtist(artist.getId());
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Track>> getFavouriteTracksByUserId(@PathVariable Long id){
        List<Track> tracks = trackService.getFavouriteTracksByUserId(id);
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Track> saveTrack(@RequestBody Track track) {
        Track newTrack = trackService.saveTrack(track);
        return new ResponseEntity<>(track, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Optional<Track>> searchTrackByName(@RequestBody String name) {
        Optional<Track> track = trackService.searchTrackByName(name);
        return new ResponseEntity<>(track, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/tracks/{trackId}")
    public ResponseEntity<String> removeTrackById(@PathVariable long trackId) {
        Reply reply = trackService.removeTrackById(trackId);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

}