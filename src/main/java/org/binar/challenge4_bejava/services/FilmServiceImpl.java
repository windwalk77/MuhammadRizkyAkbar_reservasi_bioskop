package org.binar.challenge4_bejava.services;

import org.binar.challenge4_bejava.models.entities.FilmEntity;
import org.binar.challenge4_bejava.models.entities.UserEntity;
import org.binar.challenge4_bejava.models.repos.FilmRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepos filmRepos;

    @Override
    public FilmEntity addFilm(FilmEntity film) {
        return filmRepos.save(film);
    }

    @Override
    public void deleteFilm(Long id) {
        filmRepos.deleteById(id);
    }

    @Override
    public FilmEntity updateFilm(FilmEntity film) {
        return filmRepos.save(film);
    }

    @Override
    public FilmEntity findFilm(Long id) {
        Optional<FilmEntity>film= filmRepos.findById(id);
        return film.orElse(null);
    }

    @Override
    public List<FilmEntity> findAll() {
        return filmRepos.findAll();
    }
}
