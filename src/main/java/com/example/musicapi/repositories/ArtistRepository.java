package com.example.musicapi.repositories;

import com.example.musicapi.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findByTrackId(Long id);
    List<Artist> findByAlbumId(Long id);
}
