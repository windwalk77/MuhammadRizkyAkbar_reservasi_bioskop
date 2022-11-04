package org.binar.challenge4_bejava.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.binar.challenge4_bejava.dto.EnumRole;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "Roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private EnumRole name;

}
