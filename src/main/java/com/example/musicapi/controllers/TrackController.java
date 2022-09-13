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

    @GetMapping(value = "/genre")
    public ResponseEntity<List<Track>> getTracksByGenre(@PathVariable Genre genre){
        List<Track> tracks = trackService.getTracksByGenre(genre);
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @GetMapping(value = "/artist/{id}")
    public ResponseEntity<List<Track>> getTracksByArtistId(@PathVariable long id){
        List<Track> tracks = trackService.getTracksByArtistId(id);
        return tracks != null ? new ResponseEntity<>(tracks, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

//    @GetMapping(value = "/album/{id}")
//    public ResponseEntity<List<Track>> getTracksByAlbumId(@PathVariable long id){
//        List<Track> tracks = trackService.getTracksByAlbumId(id);
//        return tracks != null ? new ResponseEntity<>(tracks, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }

    @GetMapping(value = "/favourites/{id}")
    public ResponseEntity<List<Track>> getFavouriteTracksByUserId(@PathVariable Long id){
        List<Track> tracks = trackService.getFavouriteTracksByUserId(id);
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Track> saveTrack(@RequestBody Track track) {
        Track newTrack = trackService.saveTrack(track);
        return new ResponseEntity<>(track, HttpStatus.CREATED);
    }

    @GetMapping(value = "/search/{name}")
    public ResponseEntity<Optional<Track>> searchTrackByName(@PathVariable String name) {
        Optional<Track> track = trackService.searchTrackByName(name);
        return track.isPresent() ? new ResponseEntity<>(track, HttpStatus.CREATED) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeTrackById(@PathVariable long id) {
        Reply reply = trackService.removeTrackById(id);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

}
