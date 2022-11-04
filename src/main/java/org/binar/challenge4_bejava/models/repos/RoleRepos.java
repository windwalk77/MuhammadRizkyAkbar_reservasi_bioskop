package org.binar.challenge4_bejava.models.repos;

import org.binar.challenge4_bejava.dto.EnumRole;
import org.binar.challenge4_bejava.models.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepos extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(EnumRole name);
}
