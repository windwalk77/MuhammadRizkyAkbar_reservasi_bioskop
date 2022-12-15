package com.binar.schedules.models.repos;

import com.binar.schedules.models.entities.ScheduleEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScheduleRepos extends JpaRepository<ScheduleEntity,Long> {
    @Query("select s from ScheduleEntity s where s.film.idFilm = ?1")
    List<ScheduleEntity> findScheduleByMoviesId(Long idFilm);
}
