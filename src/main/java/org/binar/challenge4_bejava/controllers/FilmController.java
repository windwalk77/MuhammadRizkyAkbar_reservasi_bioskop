package org.binar.challenge4_bejava.controllers;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.binar.challenge4_bejava.dto.ResponseData;
import org.binar.challenge4_bejava.models.entities.FilmEntity;
import org.binar.challenge4_bejava.models.entities.UserEntity;
import org.binar.challenge4_bejava.services.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@SecurityRequirement(name = "Authorize")
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmServiceImpl filmService;

    @PostMapping("/create")
    public ResponseEntity<ResponseData<FilmEntity>> create(@Valid @RequestBody FilmEntity film , Errors errors){
        ResponseData<FilmEntity> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            log.error("Failed to add film");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(filmService.addFilm(film));
        log.error("Successfully add film");
        return ResponseEntity.ok(responseData);
    }
    @GetMapping("/get/{id}")
    public FilmEntity findFilm(@PathVariable("id") Long ID){
        return filmService.findFilm(ID);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseData<FilmEntity>> update(@Valid @RequestBody FilmEntity film , Errors errors){
        ResponseData<FilmEntity> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            log.error("Failed to update film");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(filmService.addFilm(film));
        log.error("Successfully update film");
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFilm(@PathVariable("id") Long ID){
        filmService.deleteFilm(ID);
    }

    @GetMapping("/get/all")
    public Iterable<FilmEntity> findAllFilms(){
        return filmService.findAll();
    }

    @GetMapping("/get/allAvailable")
    public List<FilmEntity> findAvailableFilms(){
        log.info("Successfully find available film");
        List<FilmEntity> filmsAvailable = filmService.findAll().stream().filter(FilmEntity::isStatus).collect(Collectors.toList());
        return filmsAvailable;
    }


}
