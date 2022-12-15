package com.binar.films.models.repos;


import com.binar.films.models.entities.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepos extends JpaRepository<FilmEntity,Long> {
}
