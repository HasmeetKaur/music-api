package com.example.musicapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByArtistId();
    List<Album> findByTrackId();

}
