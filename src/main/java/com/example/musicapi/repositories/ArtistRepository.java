package com.example.musicapi.repositories;

import com.example.musicapi.models.Artist;
import com.example.musicapi.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findByGenre(Genre genre);

    Optional<Artist> findByName(String name);
}
