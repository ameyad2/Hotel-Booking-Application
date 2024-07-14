package com.adprojects.hotel_lakeSide.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Ameya Deshmukh
 */
@Data
public class LoginRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}