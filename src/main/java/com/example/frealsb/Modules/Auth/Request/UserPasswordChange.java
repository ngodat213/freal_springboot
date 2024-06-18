package com.example.frealsb.Modules.Auth.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserPasswordChange(
        @NotBlank(message = "old password is mandatory")
        @Size(min = 8, message = "old password must have at least 8 characters")
        String oldPassword,

        @NotBlank(message = "new password is mandatory")
        @Size(min = 8, message = "new password must have at least 8 characters")
        String newPassword

) {
}