package org.binar.challenge4_bejava.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "Users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user" )
    private Long idUser;

    @NotEmpty(message = "Username tidak boleh kosong")
    @Column(length = 50)
    private String username;

    @Email(message = "Email tidak valid")
    @NotEmpty(message = "Email tidak boleh kosong")
    @Column(length = 50)
    private String email;

    @NotEmpty(message = "Password tidak boleh kosong")
    @Column(length = 50)
    private String password;

}
