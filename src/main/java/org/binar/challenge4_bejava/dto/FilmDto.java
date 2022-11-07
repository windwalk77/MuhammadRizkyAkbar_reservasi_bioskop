package org.binar.challenge4_bejava.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FilmDto {
    private Long idFilm;

    private String namaFilm;

    private boolean status;
}
