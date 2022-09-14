package com.example.musicapi.controllers;

import com.example.musicapi.models.Reply;
import com.example.musicapi.models.User;
import com.example.musicapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        return userService.getUserById(id).isPresent() ? new ResponseEntity<>(userService.getUserById(id).get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeUserById(@PathVariable long id) {
        Reply reply = userService.removeUserById(id);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/{userId}/favourites/tracks/{trackId}")
    public ResponseEntity<String> addTrackToFavouritesById(@PathVariable long userId, @PathVariable long trackId) {
        Reply reply = userService.addTrackToFavouritesById(trackId, userId);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/{userId}/favourites/albums/{albumId}")
    public ResponseEntity<String> addAlbumToFavouritesById(@PathVariable long userId, @PathVariable long albumId) {
        Reply reply = userService.addAlbumToFavouritesById(albumId, userId);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/{userId}/favourites/artists/{artistId}")
    public ResponseEntity<String> addArtistToFavouritesById(@PathVariable long userId, @PathVariable long artistId) {
        Reply reply = userService.addArtistToFavouritesById(artistId, userId);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{userId}/favourites/tracks/{trackId}")
    public ResponseEntity<String> removeTrackFromFavouritesById(@PathVariable long userId, @PathVariable long trackId) {
        Reply reply = userService.removeTrackFromFavouritesById(trackId, userId);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{userId}/favourites/albums/{albumId}")
    public ResponseEntity<String> removeAlbumFromFavouritesById(@PathVariable long userId, @PathVariable long albumId) {
        Reply reply = userService.removeAlbumFromFavouritesById(albumId, userId);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{userId}/favourites/artists/{artistId}")
    public ResponseEntity<String> removeArtistFromFavouritesById(@PathVariable long userId, @PathVariable long artistId) {
        Reply reply = userService.removeArtistFromFavouritesById(artistId, userId);
        return reply.isPassed() ? new ResponseEntity<>(reply.getMessage(), HttpStatus.OK) : new ResponseEntity<>(reply.getMessage(), HttpStatus.NOT_FOUND);
    }
}
