package org.binar.challenge4_bejava.models.repos;

import org.binar.challenge4_bejava.models.entities.RoleEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.binar.challenge4_bejava.dto.EnumRole.ADMIN;
import static org.binar.challenge4_bejava.dto.EnumRole.CUSTOMER;


@DataJpaTest
class RoleReposTest {

    @Autowired
    private RoleRepos roleRepos;

    @AfterEach
    void reset() {
        roleRepos.deleteAll();
    }

    @Test
    void findByNameFound() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(ADMIN);
        roleRepos.save(roleEntity);
        assertThat(roleRepos.findByName(ADMIN)).isPresent();
    }
    @Test
    void findByNameNotFound() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(CUSTOMER);
        roleRepos.save(roleEntity);
        assertThat(roleRepos.findByName(ADMIN)).isNotPresent();
    }
}