package org.binar.challenge4_bejava.services;


import org.binar.challenge4_bejava.models.entities.FilmEntity;

import java.util.List;


public interface FilmService {
    FilmEntity addFilm(FilmEntity film);
    void deleteFilm(Long id);
    FilmEntity updateFilm(FilmEntity film);
    FilmEntity findFilm(Long id);
    List<FilmEntity> findAll();
}
