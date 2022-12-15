package com.binar.schedules.models.repos;

import com.binar.schedules.models.entities.StudioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepos extends JpaRepository<StudioEntity,Long> {
}
