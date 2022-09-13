package com.example.musicapi.repositories;

import com.example.musicapi.models.Artist;
import com.example.musicapi.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findByTrackId(Long id);
    List<Artist> findByAlbumId(Long id);

    List<Artist> findByUserId();
    
    List<Artist> findById();
    List<Artist> findByGenre(Genre genre);

    List<Artist> findFavouriteArtistByUserId(long id);

    List<Artist> saveArtist(Artist artist);

    Optional<Artist> removeArtistById(long id);

    Optional<Artist> searchArtistByName(String name);
}
