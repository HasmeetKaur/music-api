package com.example.musicapi.repositories;

import com.example.musicapi.models.Album;
import com.example.musicapi.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Optional<List<Album>> findByArtistId(Long id);

    @Query(value = "SELECT al.*n FROM albums al INNER JOIN artists ar ON al.artist_id = ar.id INNER JOIN tracks t ON t.artist_id = ar.id WHERE t.id = :id", nativeQuery = true)
    Optional<Album> findByTrackId(@Param("id") Long id);

    List<Album> findByGenre(Genre genre);

    @Query("SELECT al FROM albums al WHERE LOWER(al.name) LIKE lower(concat('%', :name,'%'))")
    Optional<List<Album>> findByName(@Param("name") String name);
}
