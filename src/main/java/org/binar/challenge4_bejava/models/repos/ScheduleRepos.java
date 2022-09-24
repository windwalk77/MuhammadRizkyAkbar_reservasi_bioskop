package org.binar.challenge4_bejava.models.repos;

import org.binar.challenge4_bejava.models.entities.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleRepos extends JpaRepository<ScheduleEntity,Long> {
    @Query("select s from ScheduleEntity s where s.Film.idFilm = ?1")
    Optional<ScheduleEntity> findScheduleByMoviesId(Long idFilm);
}
