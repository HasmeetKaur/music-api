package com.example.musicapi.repositories;

import com.example.musicapi.models.Album;
import com.example.musicapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<Album> findById(long id);
}
