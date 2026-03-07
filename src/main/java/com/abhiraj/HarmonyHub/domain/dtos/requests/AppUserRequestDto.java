package com.abhiraj.HarmonyHub.domain.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserRequestDto {

    @Size(min = 2, max = 50, message = "The name must have characters in the range 2-50")
    private String name;

    @Email(message = "Enter a valid email")
    private String email;

    @Size(min=8, message = "Password must be of length 8")
    private String password;

    private String oldPassword;

    @Pattern(regexp = "^(USER|ADMIN)$", message = "The role must be either USER or ADMIN")
    private String role;

    private String refreshToken;

}
