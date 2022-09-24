package org.binar.challenge4_bejava.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Films")
public class FilmEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private Long idFilm;

    @Column(name = "nama_film")
    private String namaFilm;

    private boolean status;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private List<ScheduleEntity> schedules = new ArrayList<>();

}
