package com.binar.schedules.controllers;

import com.binar.schedules.dto.ScheduleDto;
import com.binar.schedules.models.entities.Film;
import com.binar.schedules.models.entities.ScheduleEntity;
import com.binar.schedules.services.ScheduleServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@RestController
@SecurityRequirement(name = "Authorize")
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ScheduleServiceImpl scheduleService;
    @Autowired
    private WebClient webClient;


    @PostMapping("/create")
    public ResponseEntity<ScheduleEntity> createSchedule(@RequestBody ScheduleDto scheduleDto){
        ScheduleEntity schedule = modelMapper.map(scheduleDto,ScheduleEntity.class) ;
        Film film = webClient.get()
                .uri("http://localhost:7072/film/get/"+scheduleDto.getFilmId())
                        .retrieve().bodyToMono(Film.class).block();
        schedule.setFilm(film);
        return new ResponseEntity<>(scheduleService.addSchedule(schedule), HttpStatus.OK);
    }
    @GetMapping("/all/{idFilm}")
    public List<ScheduleEntity> findByMovie(@PathVariable("idFilm") Long id){
       return scheduleService.findByMovie(id);
    }
}
