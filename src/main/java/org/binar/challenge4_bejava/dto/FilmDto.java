package org.binar.challenge4_bejava.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FilmDto {

    @NotNull(message = "Nama Film tidak boleh kosong")
    private String namaFilm;
    @NotNull(message = "Status tidak boleh kosong")
    private boolean status;
}
