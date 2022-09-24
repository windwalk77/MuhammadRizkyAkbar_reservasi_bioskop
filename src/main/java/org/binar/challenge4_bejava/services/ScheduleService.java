package org.binar.challenge4_bejava.services;

import org.binar.challenge4_bejava.models.entities.ScheduleEntity;

import java.util.List;

public interface ScheduleService {
    ScheduleEntity addSchedule(ScheduleEntity schedule);
    void deleteSchedule(Long id);
    ScheduleEntity updateSchedule(ScheduleEntity schedule);
    ScheduleEntity findSchedule(Long id);
    Iterable<ScheduleEntity> findAll();
    List<ScheduleEntity> findByMovie(Long ID);

}
