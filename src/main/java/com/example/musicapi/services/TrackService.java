package com.example.musicapi.services;

import com.example.musicapi.models.*;
import com.example.musicapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    UserRepository userRepository;

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public Optional<Track> getTrackById(Long id) {
        return trackRepository.findById(id);
    }

    public List<Track> getTracksByArtistId(Long id) {
        Optional<List<Track>> tracks = trackRepository.findByArtistId(id);
        if (tracks.isEmpty()) {
            return null;
        } else {
            return tracks.get();
        }
    }

    public List<Track> getTracksByAlbumId(Long id) {
        Optional<List<Track>> tracks = trackRepository.findByAlbumId(id);
        if (tracks.isEmpty()) {
            return null;
        } else {
            return tracks.get();
        }
    }

    public List<Track> getTracksByGenre(Genre genre) {
        return trackRepository.findByGenre(genre);
    }

    public List<Track> getFavouriteTracksByUserId(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return null;
        } else {
            return user.get().getFavouriteTracks();
        }
    }

    public Track saveTrack(Track track) {
        trackRepository.save(track);
        return track;
    }

    public Reply removeTrackById(Long id) {
        Optional<Track> track = trackRepository.findById(id);
        if (track.isEmpty()) {
            return new Reply(false, "Track not found.");
        } else {
            trackRepository.delete(track.get());
            return new Reply(true, "Track successfully deleted.");
        }
    }

    public Optional<Track> searchTrackByName(String name) {
        return trackRepository.findByName(name);

    }

}