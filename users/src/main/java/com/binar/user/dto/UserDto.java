package com.binar.user.dto;

import com.binar.user.models.entities.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long idUser;

    @NotEmpty(message = "Username tidak boleh kosong")
    private String username;

    @Email(message = "Email tidak valid")
    @NotEmpty(message = "Email tidak boleh kosong")
    private String email;
    @NotEmpty(message = "Password tidak boleh kosong")
    private String password;

    private Set<RoleEntity> roles = new HashSet<>();
}
