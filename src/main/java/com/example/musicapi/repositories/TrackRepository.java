package com.example.musicapi.repositories;

import com.example.musicapi.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {

    List<Track> findByArtistId(Long id);
    List<Track> findByAlbumId(Long id);
}
