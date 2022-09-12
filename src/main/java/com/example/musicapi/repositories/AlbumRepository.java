package com.example.musicapi.repositories;

import com.example.musicapi.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByArtistId();
    List<Album> findByTrackId();

}
