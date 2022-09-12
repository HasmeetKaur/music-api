package com.example.musicapi.services;

import com.example.musicapi.models.Reply;
import com.example.musicapi.models.Track;
import com.example.musicapi.models.User;
import com.example.musicapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public Reply removeUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return new Reply(false, "User not found.");
        } else {
            userRepository.delete(user.get());
            return new Reply(true, "User successfully deleted.");
        }
    }

    public Reply addTrackToFavouritesById(Long trackId, Long userId) {
        
    }
}
