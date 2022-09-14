package com.example.musicapi.services;

import com.example.musicapi.models.*;
import com.example.musicapi.repositories.ArtistRepository;
import com.example.musicapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    UserRepository userRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtistById(long id) {
        return artistRepository.findById(id);
    }

    public List<Artist> getArtistsByGenre(Genre genre) {
        return artistRepository.findByGenre(genre);
    }

    public List<Artist> getFavouriteArtistsByUserId(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return null;
        } else {
            return user.get().getFavouriteArtists();
        }
    }

    public Artist saveArtist(Artist artist) {
        artistRepository.save(artist);
        return artist;
    }

    public Reply removeArtistById(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);
        if (artist.isEmpty()) {
            return new Reply(false, "Artist not found.");
        } else {
            artistRepository.delete(artist.get());
            return new Reply(true, "Artist successfully removed by id.");
        }
    }

    public Optional<List<Artist>> searchArtistByName(String name) {
        return artistRepository.findByName(name);
    }
}
