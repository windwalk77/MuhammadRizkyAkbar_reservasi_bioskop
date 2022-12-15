package com.binar.films.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FilmDtoUpdate {

    private Long idFilm;
    @NotNull(message = "Nama Film tidak boleh kosong")
    private String namaFilm;
    @NotNull(message = "Status tidak boleh kosong")
    private boolean status;
}