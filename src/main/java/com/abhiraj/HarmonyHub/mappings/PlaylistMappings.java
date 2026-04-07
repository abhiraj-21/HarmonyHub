package com.abhiraj.HarmonyHub.mappings;

import com.abhiraj.HarmonyHub.domain.dtos.responses.PlaylistResponseDto;
import com.abhiraj.HarmonyHub.domain.entities.Playlist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PlaylistMappings {

    public PlaylistResponseDto playlistToResponse(Playlist playlist, String baseUrl){
        return PlaylistResponseDto.builder()
                .updatedAt(playlist.getUpdatedAt())
                .createdAt(playlist.getCreatedAt())
                .id(playlist.getId())
                .name(playlist.getName())
                .appUserId(playlist.getAppUser().getId())
                .appUserName(playlist.getAppUser().getName())
                .description(playlist.getDescription())
                .imageUrl(playlist.getImageUrl() != null ? baseUrl + playlist.getImageUrl() : null)
                .isPublic(playlist.getIsPublic())
                .build();
    }

}
