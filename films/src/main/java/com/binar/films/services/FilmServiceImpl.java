package com.binar.films.services;

import com.binar.films.models.entities.FilmEntity;
import com.binar.films.models.repos.FilmRepos;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepos filmRepos;

    @Override
    public FilmEntity addFilm(FilmEntity film) {
        log.info("Succesfully add film");
        return filmRepos.save(film);
    }

    @Override
    public void deleteFilm(Long id) {
        log.info("Succesfully delete film");
        filmRepos.deleteById(id);
    }

    @Override
    public FilmEntity updateFilm(FilmEntity film) {
        log.info("Succesfully update film");

        return filmRepos.save(film);
    }

    @Override
    public FilmEntity findFilm(Long id) {
        log.info("Succesfully find film");
        Optional<FilmEntity>film= filmRepos.findById(id);
        return film.orElse(null);
    }

    @Override
    public List<FilmEntity> findAll() {

        log.info("Succesfully find all film");
        return filmRepos.findAll();
    }
}
