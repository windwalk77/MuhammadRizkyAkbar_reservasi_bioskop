package org.binar.challenge4_bejava.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.binar.challenge4_bejava.dto.EnumRole;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "Roles")
public class RoleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private EnumRole name;

}
