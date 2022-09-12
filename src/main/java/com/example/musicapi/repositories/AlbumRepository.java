package com.example.musicapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByArtistId(Long id);
    List<Album> findByTrackId(Long id);

}
