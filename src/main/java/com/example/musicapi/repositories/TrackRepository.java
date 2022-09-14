package com.example.musicapi.repositories;

import com.example.musicapi.models.Genre;
import com.example.musicapi.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TrackRepository extends JpaRepository<Track, Long> {

    Optional<List<Track>> findByArtistId(Long id);
//    Optional<List<Track>> findByAlbumId(Long id);
    List<Track> findByGenre(Genre genre);

    @Query("SELECT t FROM tracks t WHERE LOWER(t.name) LIKE lower(concat('%', :name,'%'))")
    Optional<List<Track>> findByName (@Param("name") String name);
}
