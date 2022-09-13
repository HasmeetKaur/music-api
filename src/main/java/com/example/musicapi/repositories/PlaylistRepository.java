package com.example.musicapi.repositories;

import com.example.musicapi.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    Optional<List<Playlist>> findByUserId(Long id);
}
