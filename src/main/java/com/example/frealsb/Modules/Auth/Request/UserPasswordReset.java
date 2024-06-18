package com.example.frealsb.Modules.Auth.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserPasswordReset(
        @NotBlank(message = "email is mandatory")
        @Email(message = "email not valid")
        String email,

        @NotBlank(message = "email is mandatory")
        @Size(min = 6, max = 6, message = "otp length must be 6")
        String otpCode,

        @NotBlank(message = "new password is mandatory")
        @Size(min = 8, message = "new password must have at least 8 characters")
        String newPassword
) {
}