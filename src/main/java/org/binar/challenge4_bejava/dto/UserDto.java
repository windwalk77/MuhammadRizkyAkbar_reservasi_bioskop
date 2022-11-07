package org.binar.challenge4_bejava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binar.challenge4_bejava.models.entities.RoleEntity;


import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long idUser;

    private String username;


    private String email;
    private String password;

    private Set<RoleEntity> roles = new HashSet<>();
}
