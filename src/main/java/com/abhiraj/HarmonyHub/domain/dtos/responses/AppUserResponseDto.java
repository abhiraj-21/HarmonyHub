package com.abhiraj.HarmonyHub.domain.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserResponseDto {

     private Long id;
     private String name;
     private String email;
     private String role;
     private String accessToken;
     private String refreshToken;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;

}
