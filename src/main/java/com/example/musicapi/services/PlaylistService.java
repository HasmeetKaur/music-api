package com.example.musicapi.services;

import com.example.musicapi.models.Playlist;
import com.example.musicapi.models.Reply;
import com.example.musicapi.models.Track;
import com.example.musicapi.models.User;
import com.example.musicapi.repositories.PlaylistRepository;
import com.example.musicapi.repositories.TrackRepository;
import com.example.musicapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    UserRepository userRepository;

    public List<Playlist> getAllUsersPlaylistsById(long id) {
        return playlistRepository.findByUserId(id);
    }

    public Playlist getUsersPlaylistById(long userId, long playlistId) {
        List<Playlist> playlists = playlistRepository.findByUserId(userId);

        Playlist playlistToReturn = null;

        for(Playlist playlist : playlists) {
            if (playlist.getId() == playlistId) {
                playlistToReturn = playlist;
            }
        };
        return playlistToReturn;
    }

    public Optional<Playlist> addTrackToPlaylistById(long trackId, long playlistId) {
        Optional<Playlist> playlist = playlistRepository.findById(playlistId);
        Optional<Track> track = trackRepository.findById(trackId);

        if (playlist.isEmpty() || track.isEmpty()) {
            return null;
        } else {
            playlist.get().getTracks().add(track.get());
            return playlist;
        }
    }

    public Reply removeTrackFromPlaylistById(long playlistId, long trackId) {
        Optional<Playlist> playlist = playlistRepository.findById(playlistId);
        Optional<Track> track = trackRepository.findById(trackId);

        if (track.isEmpty() || playlist.isEmpty()) {
            return new Reply(false, "Not found.");
        } else {
            playlist.get().getTracks().remove(track.get());
            return new Reply(true, "Track successfully removed from playlist.");
        }
    }

    public Playlist createNewPlaylist(String name, long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        } else {
            return new Playlist(name, user.get());
        }
    }

    public Reply removePlaylistById(long id) {
        Optional<Playlist> playlist = playlistRepository.findById(id);

        if (playlist.isEmpty()) {
            return new Reply(false, "Not found.");
        } else {
            playlistRepository.delete(playlist.get());
            return new Reply(true, "Playlist deleted.");
        }
    }
}
