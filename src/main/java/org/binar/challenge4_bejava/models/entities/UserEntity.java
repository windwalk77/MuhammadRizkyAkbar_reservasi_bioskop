package org.binar.challenge4_bejava.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user" )
    private Long idUser;

    @NotEmpty(message = "Username tidak boleh kosong")
    @Column(columnDefinition="TEXT")
    private String username;

    @Email(message = "Email tidak valid")
    @NotEmpty(message = "Email tidak boleh kosong")
    @Column(columnDefinition="TEXT")
    private String email;

    @NotEmpty(message = "Password tidak boleh kosong")
    @Column(columnDefinition="TEXT")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();


}
