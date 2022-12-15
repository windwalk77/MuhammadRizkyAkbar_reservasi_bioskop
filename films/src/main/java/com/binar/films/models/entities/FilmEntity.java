package com.binar.films.models.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Films")
public class FilmEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private Long idFilm;

    @NotNull(message = "Nama Film tidak boleh kosong")
    @Column(name = "nama_film")
    private String namaFilm;

    @NotNull(message = "Status film tidak boleh kosong")
    private boolean status;


}
