package com.abhiraj.HarmonyHub.mappings;

import com.abhiraj.HarmonyHub.domain.dtos.responses.SongResponseDto;
import com.abhiraj.HarmonyHub.domain.entities.Song;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SongMappings {

    public SongResponseDto songToResponse(Song song, String baseUrl){
        return SongResponseDto.builder()
                .songUrl(song.getSongUrl() != null ? baseUrl + song.getSongUrl() : null)
                .id(song.getId())
                .title(song.getTitle())
                .appUserId(song.getAppUser().getId())
                .appUserName(song.getAppUser().getName())
                .artist(song.getArtist())
                .createdAt(song.getCreatedAt())
                .imageUrl(song.getImageUrl() != null ? baseUrl + song.getImageUrl() : null)
                .build();
    }

}
