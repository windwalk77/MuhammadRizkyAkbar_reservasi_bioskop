package org.binar.challenge4_bejava.controllers;


import org.binar.challenge4_bejava.models.entities.FilmEntity;
import org.binar.challenge4_bejava.services.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmServiceImpl filmService;

    @PostMapping("/create")
    public FilmEntity create(@RequestBody FilmEntity film){
        return filmService.addFilm(film);
    }

    @GetMapping("/{id}")
    public FilmEntity findFilm(@PathVariable("id") Long ID){
        return filmService.findFilm(ID);
    }

    @PutMapping("/update")
    public FilmEntity updateFilm(@RequestBody FilmEntity film){
        return filmService.updateFilm(film);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFilm(@PathVariable("id") Long ID){
        filmService.deleteFilm(ID);
    }

    @GetMapping("/all")
    public Iterable<FilmEntity> findAllFilms(){
        return filmService.findAll();
    }

    @GetMapping("/allAvailable")
    public List<FilmEntity> findAvailableFilms(){
        List<FilmEntity> filmsAvailable = filmService.findAll().stream().filter(FilmEntity::isStatus).collect(Collectors.toList());
        return filmsAvailable;
    }
}
