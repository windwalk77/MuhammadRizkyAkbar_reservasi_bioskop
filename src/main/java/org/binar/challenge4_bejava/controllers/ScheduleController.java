package org.binar.challenge4_bejava.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.binar.challenge4_bejava.models.entities.ScheduleEntity;
import org.binar.challenge4_bejava.services.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@SecurityRequirement(name = "Authorize")
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleServiceImpl scheduleService;

    @GetMapping("/all/{idFilm}")
    public List<ScheduleEntity> findByMovie(@PathVariable("idFilm") Long id){
       return scheduleService.findByMovie(id);
    }
}
