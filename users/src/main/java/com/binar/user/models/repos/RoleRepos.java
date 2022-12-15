package com.binar.user.models.repos;

import com.binar.user.dto.EnumRole;
import com.binar.user.models.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepos extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(EnumRole name);
}
