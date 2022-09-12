package com.example.musicapi.services;

import com.example.musicapi.models.Track;
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
    AlbumRepository albumRepository;

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    UserRepository userRepository;

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public Optional<Track> getTrackById(Long id) {
        return trackRepository.findById(id);
    }

    public List<Track> getTracksByArtistId(Long id) {
        return trackRepository.findByArtistId(id);
    }

    public List<Track> getTrackByAlbumId(Long id) {
        return trackRepository.findByArtistId(id);
    }

    public List<Track> getFavoriteTracksByUserId(Long id) {
        return userRepository.findByUserId(id).get().getFavoriteTracks();
    }