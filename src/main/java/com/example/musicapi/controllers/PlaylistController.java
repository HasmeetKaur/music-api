package com.example.musicapi.controllers;

import com.example.musicapi.models.Playlist;
import com.example.musicapi.models.Reply;
import com.example.musicapi.models.Track;
import com.example.musicapi.services.PlaylistService;
import com.example.musicapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        return new ResponseEntity<>(playlistService.getAllPlaylists(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Playlist>> getAllUsersPlaylistsById(@PathVariable long userId) {
        Optional<List<Playlist>> playlists =  playlistService.getAllUsersPlaylistsById(userId);
        return playlists.isPresent() ? new ResponseEntity<>(playlists.get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{playlistId}/tracks/{trackId}")
    public ResponseEntity<Playlist> addTrackToPlaylistById(@PathVariable long playlistId, @PathVariable long trackId) {
        Optional<Playlist> playlist = playlistService.addTrackToPlaylistById(trackId, playlistId);
        return playlist.isPresent() ? new ResponseEntity<>(playlist.get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{playlistId}/tracks/{trackId}")
    public ResponseEntity<String> removeTrackFromFavouritesById(@PathVariable long playlistId, @PathVariable long trackId) {
        Reply reply = playlistService.removeTrackFromPlaylistById(playlistId, trackId);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{userId}/{playlistName}")
    public ResponseEntity<Playlist> savePlaylist(@PathVariable long userId, @PathVariable String playlistName) {
        Playlist newPlaylist = playlistService.createNewPlaylist(playlistName, userId);
        return newPlaylist == null ? new ResponseEntity<>(newPlaylist, HttpStatus.NOT_FOUND) : new ResponseEntity<>(newPlaylist, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removePlaylistById(@PathVariable long id) {
        Reply reply = playlistService.removePlaylistById(id);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/shuffle/{id}")
    public ResponseEntity<List<Track>> shufflePlaylist(@PathVariable long id) {
        List<Track> playlist = playlistService.shufflePlaylistById(id);
        return playlist != null ? new ResponseEntity<>(playlist, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
