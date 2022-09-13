package com.example.musicapi.repositories;

import com.example.musicapi.models.Genre;
import com.example.musicapi.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrackRepository extends JpaRepository<Track, Long> {

    List<Track> findByArtistId(Long id);
    List<Track> findByAlbumId(Long id);
    List<Track> findByGenre(Genre genre);
    List<Track> findByUserId(long id);
    Optional<Track> searchTrackByName (String name);
}
