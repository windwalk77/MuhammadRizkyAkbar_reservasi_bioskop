package com.binar.films.services;




import com.binar.films.models.entities.FilmEntity;

import java.util.List;


public interface FilmService {
    FilmEntity addFilm(FilmEntity film);
    void deleteFilm(Long id);
    FilmEntity updateFilm(FilmEntity film);
    FilmEntity findFilm(Long id);
    List<FilmEntity> findAll();
}
