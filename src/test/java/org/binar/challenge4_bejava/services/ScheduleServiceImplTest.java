package org.binar.challenge4_bejava.services;

import org.binar.challenge4_bejava.models.repos.ScheduleRepos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class ScheduleServiceImplTest {
    @Mock
    private ScheduleRepos scheduleRepos;
    @InjectMocks
    private ScheduleServiceImpl scheduleService;
    @Test
    void findByMovie() {
        scheduleService.findByMovie(1L);
        verify(scheduleRepos).findScheduleByMoviesId(1L);

    }
}