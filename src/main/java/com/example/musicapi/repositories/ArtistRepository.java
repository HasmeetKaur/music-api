package com.example.musicapi.repositories;

import com.example.musicapi.models.Artist;
import com.example.musicapi.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findByGenre(Genre genre);

    @Query("SELECT a FROM artists a WHERE LOWER(a.name) LIKE lower(concat('%', :name,'%'))")
    Optional<List<Artist>> findByName(@Param("name") String name);
}
