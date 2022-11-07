package org.binar.challenge4_bejava.services;

import org.binar.challenge4_bejava.models.entities.FilmEntity;
import org.binar.challenge4_bejava.models.repos.FilmRepos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class FilmServiceImplTest {

    @Mock
    private FilmRepos filmRepos;
    @InjectMocks
    private FilmServiceImpl filmService;

    @Test
    void addFilm() {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setNamaFilm("Apenjer");
        filmEntity.setStatus(true);
        filmService.addFilm(filmEntity);
        ArgumentCaptor<FilmEntity> userEntityArgumentCaptor = ArgumentCaptor.forClass(FilmEntity.class);
        verify(filmRepos).save(userEntityArgumentCaptor.capture());

        FilmEntity captureFilm = userEntityArgumentCaptor.getValue();
        assertThat(captureFilm).isEqualTo(filmEntity);

    }

    @Test
    void deleteFilm() {
        filmService.deleteFilm(1L);
        verify(filmRepos).deleteById(1L);
    }

    @Test
    void updateFilm() {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setNamaFilm("Apenjer");
        filmEntity.setStatus(true);
        filmService.updateFilm(filmEntity);
        ArgumentCaptor<FilmEntity> userEntityArgumentCaptor = ArgumentCaptor.forClass(FilmEntity.class);
        verify(filmRepos).save(userEntityArgumentCaptor.capture());

        FilmEntity captureFilm = userEntityArgumentCaptor.getValue();
        assertThat(captureFilm).isEqualTo(filmEntity);

    }

    @Test
    void findFilm() {
        filmService.findFilm(1L);
        verify(filmRepos).findById(1L);
    }

    @Test
    void findAll() {
        filmService.findAll();
        verify(filmRepos).findAll();
    }
}