package com.abhiraj.HarmonyHub.mappings;

import com.abhiraj.HarmonyHub.domain.dtos.responses.AppUserResponseDto;
import com.abhiraj.HarmonyHub.domain.entities.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppUserMappings {

    public AppUserResponseDto userToResponse(AppUser user, String accessToken, String refreshToken){
        return AppUserResponseDto.builder()
                .accessToken(accessToken)
                .id(user.getId())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .email(user.getEmail())
                .name(user.getName())
                .refreshToken(refreshToken)
                .role(user.getRole())
                .build();
    }

}
