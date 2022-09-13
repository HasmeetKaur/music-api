package com.example.musicapi.repositories;

import com.example.musicapi.models.Album;
import com.example.musicapi.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Optional<List<Album>> findByArtistId(Long id);
    Optional<Album> findByTrackId(Long id);

    List<Album> findByGenre(Genre genre);

    Optional<Album> findByName(String name);
}
