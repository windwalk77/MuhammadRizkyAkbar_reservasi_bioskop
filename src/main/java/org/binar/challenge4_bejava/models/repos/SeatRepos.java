package org.binar.challenge4_bejava.models.repos;

import org.binar.challenge4_bejava.models.entities.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepos extends JpaRepository<SeatEntity,Long> {
}
