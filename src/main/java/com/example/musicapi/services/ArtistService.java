package com.example.musicapi.services;

import com.example.musicapi.models.*;
import com.example.musicapi.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    public List<Artist> getAllArtist() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtistById(long id) {
        return artistRepository.findById(id);
    }

    public List<Artist> getArtistByGenre(Genre genre) {
        return artistRepository.findByGenre(genre);
    }

    public List<Artist> getFavouriteArtistsByUserId(long id) {
        return artistRepository.findFavouriteArtistsByUserId(id);
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

    public Optional<Artist> searchArtistByName(String name) {
        return artistRepository.searchArtistByName(name);
    }
}
