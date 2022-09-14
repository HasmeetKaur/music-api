package com.example.musicapi.services;

import com.example.musicapi.models.*;
import com.example.musicapi.repositories.AlbumRepository;
import com.example.musicapi.repositories.ArtistRepository;
import com.example.musicapi.repositories.TrackRepository;
import com.example.musicapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TrackRepository trackRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    ArtistRepository artistRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public Reply removeUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return new Reply(false, "User not found.");
        } else {
            userRepository.delete(user.get());
            return new Reply(true, "User successfully deleted.");
        }
    }

    public Reply addTrackToFavouritesById(Long trackId, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Track> track = trackRepository.findById(trackId);

        if (user.isEmpty() || track.isEmpty()) {
            return new Reply(false, "Not found.");
        } else {
            user.get().getFavouriteTracks().add(track.get());
            userRepository.save(user.get());
            return new Reply(true, "Track successfully added to favourites.");
        }
    }

    public Reply addAlbumToFavouritesById(Long albumId, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Album> album = albumRepository.findById(albumId);

        if (user.isEmpty() || album.isEmpty()) {
            return new Reply(false, "Not found.");
        } else {
            user.get().getFavouriteAlbums().add(album.get());
            userRepository.save(user.get());
            return new Reply(true, "Album successfully added to favourites.");
        }
    }

    public Reply addArtistToFavouritesById(Long artistId, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Artist> artist = artistRepository.findById(artistId);

        if (user.isEmpty() || artist.isEmpty()) {
            return new Reply(false, "Not found.");
        } else {
            user.get().getFavouriteArtists().add(artist.get());
            userRepository.save(user.get());
            return new Reply(true, "Artist successfully added to favourites.");
        }
    }

    public Reply removeTrackFromFavouritesById(Long trackId, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Track> track = trackRepository.findById(trackId);

        if (user.isEmpty() || track.isEmpty()) {
            return new Reply(false, "Not found.");
        } else if (!user.get().getFavouriteTracks().contains(track.get())) {
            return new Reply(false, "Track not in favourites.");
        } else {
            user.get().getFavouriteTracks().remove(track.get());
            userRepository.save(user.get());
            return new Reply(true, "Track successfully removed from favourites.");
        }
    }

    public Reply removeAlbumFromFavouritesById(Long albumId, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Album> album = albumRepository.findById(albumId);

        if (user.isEmpty() || album.isEmpty()) {
            return new Reply(false, "Not found.");
        } else if (!user.get().getFavouriteAlbums().contains(album.get())) {
            return new Reply(false, "Album not in favourites.");
        } else {
            user.get().getFavouriteAlbums().remove(album.get());
            userRepository.save(user.get());
            return new Reply(true, "Album successfully removed from favourites.");
        }
    }

    public Reply removeArtistFromFavouritesById(Long artistId, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Artist> artist = artistRepository.findById(artistId);

        if (user.isEmpty() || artist.isEmpty()) {
            return new Reply(false, "Not found.");
        } else if (!user.get().getFavouriteArtists().contains(artist.get())) {
            return new Reply(false, "Artist in favourites.");
        } else {
            user.get().getFavouriteArtists().remove(artist.get());
            userRepository.save(user.get());
            return new Reply(true, "Artist successfully removed from favourites.");
        }
    }
}
