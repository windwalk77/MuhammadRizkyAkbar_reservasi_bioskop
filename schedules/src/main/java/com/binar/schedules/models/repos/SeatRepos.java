package com.binar.schedules.models.repos;

import com.binar.schedules.models.entities.SeatEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepos extends JpaRepository<SeatEntity,Long> {
}
