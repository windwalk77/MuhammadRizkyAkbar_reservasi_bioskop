package com.binar.schedules.models.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "FilmsSchedule")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private Long idFilm;

    private String namaFilm;

    private boolean status;


}
