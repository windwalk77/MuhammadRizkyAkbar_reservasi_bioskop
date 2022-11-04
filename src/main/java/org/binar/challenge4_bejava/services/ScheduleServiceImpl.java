package org.binar.challenge4_bejava.services;

import lombok.extern.slf4j.Slf4j;
import org.binar.challenge4_bejava.models.entities.FilmEntity;
import org.binar.challenge4_bejava.models.entities.ScheduleEntity;
import org.binar.challenge4_bejava.models.repos.ScheduleRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private ScheduleRepos scheduleRepos;

    @Override
    public ScheduleEntity addSchedule(ScheduleEntity schedule) {
        log.info("Succesfully Add Schedule");
        return scheduleRepos.save(schedule);
    }

    @Override
    public void deleteSchedule(Long id) {
        log.info("Succesfully Delete Schedule");

        scheduleRepos.deleteById(id);
    }

    @Override
    public ScheduleEntity updateSchedule(ScheduleEntity schedule) {

        log.info("Succesfully Update Schedule");
        return scheduleRepos.save(schedule);
    }

    @Override
    public ScheduleEntity findSchedule(Long id) {
        log.info("Succesfully Find Schedule");
        Optional<ScheduleEntity> film= scheduleRepos.findById(id);
        return film.orElse(null);

    }

    @Override
    public Iterable<ScheduleEntity> findAll() {

        log.info("Succesfully Find All Schedule");
        return scheduleRepos.findAll();
    }

    @Override
    public List<ScheduleEntity> findByMovie(Long id) {

        List<ScheduleEntity> scheduleMovie = scheduleRepos.findScheduleByMoviesId(id).stream().collect(Collectors.toList());
        log.info("Succesfully Find Movie Schedule");
        return scheduleMovie;
    }
}
