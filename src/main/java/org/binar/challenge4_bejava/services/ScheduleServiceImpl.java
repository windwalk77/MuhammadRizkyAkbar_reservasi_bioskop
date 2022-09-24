package org.binar.challenge4_bejava.services;

import org.binar.challenge4_bejava.models.entities.FilmEntity;
import org.binar.challenge4_bejava.models.entities.ScheduleEntity;
import org.binar.challenge4_bejava.models.repos.ScheduleRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private ScheduleRepos scheduleRepos;

    @Override
    public ScheduleEntity addSchedule(ScheduleEntity schedule) {
        return scheduleRepos.save(schedule);
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleRepos.deleteById(id);
    }

    @Override
    public ScheduleEntity updateSchedule(ScheduleEntity schedule) {
        return scheduleRepos.save(schedule);
    }

    @Override
    public ScheduleEntity findSchedule(Long id) {
        Optional<ScheduleEntity> film= scheduleRepos.findById(id);
        return film.orElse(null);

    }

    @Override
    public Iterable<ScheduleEntity> findAll() {
        return scheduleRepos.findAll();
    }

    @Override
    public List<ScheduleEntity> findByMovie(Long id) {
        List<ScheduleEntity> scheduleMovie = scheduleRepos.findScheduleByMoviesId(id).stream().collect(Collectors.toList());
        return scheduleMovie;
    }
}
