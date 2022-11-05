package org.binar.challenge4_bejava.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.binar.challenge4_bejava.models.entities.FilmEntity;
import org.binar.challenge4_bejava.models.entities.ScheduleEntity;
import org.binar.challenge4_bejava.services.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@SecurityRequirement(name = "Authorize")
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleServiceImpl scheduleService;

//    @PostMapping("/create")
//    public ScheduleEntity create(@RequestBody ScheduleEntity schedule){
//        return scheduleService.addSchedule(schedule);
//    }
//
//    @GetMapping("/{id}")
//    public ScheduleEntity findSchedule(@PathVariable("id") Long ID){
//        return scheduleService.findSchedule(ID);
//    }
//
//    @PutMapping("/update")
//    public ScheduleEntity updateSchedule(@RequestBody ScheduleEntity schedule){
//        return scheduleService.updateSchedule(schedule);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteSchedule(@PathVariable("id") Long ID){
//        scheduleService.deleteSchedule(ID);
//    }
//
//    @GetMapping("/all")
//    public Iterable<ScheduleEntity> findAllSchedule(){
//        return scheduleService.findAll();
//    }

    @GetMapping("/all/{idFilm}")
    public List<ScheduleEntity> findByMovie(@PathVariable("idFilm") Long Id){
       return scheduleService.findByMovie(Id);
    }
}
