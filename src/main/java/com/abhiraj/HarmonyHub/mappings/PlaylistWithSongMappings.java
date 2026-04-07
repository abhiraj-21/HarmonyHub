package com.abhiraj.HarmonyHub.mappings;

import com.abhiraj.HarmonyHub.domain.dtos.responses.PlaylistWithSongResponseDto;
import com.abhiraj.HarmonyHub.domain.entities.Playlist;
import com.abhiraj.HarmonyHub.domain.entities.PlaylistSong;
import com.abhiraj.HarmonyHub.domain.dtos.responses.PlaylistWithSongResponseDto.SongInPlaylistResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PlaylistWithSongMappings {

    public PlaylistWithSongResponseDto playlistWithSongToResponse(Playlist playlist, List<PlaylistSong> playlistSongs, String baseUrl){

        List<SongInPlaylistResponse> songs = playlistSongs.stream()
                .map(ps -> {
                    return SongInPlaylistResponse.builder()
                            .songId(ps.getSong().getId())
                            .addedAt(ps.getAddedAt())
                            .songUrl(ps.getSong().getSongUrl() != null ? baseUrl + ps.getSong().getSongUrl() : null)
                            .title(ps.getSong().getTitle())
                            .artist(ps.getSong().getArtist())
                            .position(ps.getPosition())
                            .imageUrl(ps.getSong().getImageUrl() != null ? baseUrl + ps.getSong().getImageUrl() : null)
                            .build();
                }).toList();

        return  PlaylistWithSongResponseDto.builder()
                .name(playlist.getName())
                .id(playlist.getId())
                .description(playlist.getDescription())
                .isPublic(playlist.getIsPublic())
                .imageUrl(playlist.getImageUrl() != null ? baseUrl + playlist.getImageUrl() : null)
                .createdAt(playlist.getCreatedAt())
                .updatedAt(playlist.getUpdatedAt())
                .appUserId(playlist.getAppUser().getId())
                .appUserName(playlist.getAppUser().getName())
                .songCount(playlistSongs.size())
                .songs(songs)
                .build();
    }

}
