package org.binar.challenge4_bejava.models.repos;

import org.binar.challenge4_bejava.models.entities.FilmEntity;
import org.binar.challenge4_bejava.models.entities.ScheduleEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class ScheduleReposTest {

    @Autowired
    private ScheduleRepos scheduleRepos;

    @Autowired
    private FilmRepos filmRepos;

    @AfterEach
    void reset() {
        scheduleRepos.deleteAll();
        filmRepos.deleteAll();
    }

    @Test
    void findScheduleByMoviesIdFound() {
        ScheduleEntity scheduleEntity=new ScheduleEntity();
        scheduleEntity.setIdSchedule(1L);
        scheduleEntity.setHarga(30000L);
        scheduleEntity.setJamMulai(LocalTime.now());
        scheduleEntity.setJamSelesai(LocalTime.now());
        scheduleEntity.setTanggal(LocalDate.now());
        FilmEntity film = new FilmEntity(1L,"Ayam Berkokok",true);
        filmRepos.save(film);
        scheduleEntity.setFilm(film);
        scheduleRepos.save(scheduleEntity);

        assertThat(scheduleRepos.findScheduleByMoviesId(1L)).isNotEmpty();

    }


}