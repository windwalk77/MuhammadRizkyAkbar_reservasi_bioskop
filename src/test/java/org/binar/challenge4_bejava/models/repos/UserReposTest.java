package org.binar.challenge4_bejava.models.repos;


import org.binar.challenge4_bejava.models.entities.RoleEntity;
import org.binar.challenge4_bejava.models.entities.UserEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserReposTest {

    @Autowired
    private UserRepos userRepos;

    @AfterEach
    void reset(){
        userRepos.deleteAll();
    }

    @Test
    void findByUsernameFound() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("rizky");
        userEntity.setPassword("aa");
        userEntity.setEmail("riz@gmail.com");
        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity roleEntity = new RoleEntity();
        roles.add(roleEntity);
        userEntity.setRoles(roles);
        userRepos.save(userEntity);

        assertThat(userRepos.findByUsername("rizky")).isPresent();

    }

    @Test
    void findByUsernameNotFound() {

        assertThat(userRepos.findByUsername("rizky")).isNotPresent();

    }

    @Test
    void existsByUsernameFound() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("rizky");
        userEntity.setPassword("aa");
        userEntity.setEmail("riz@gmail.com");
        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity roleEntity = new RoleEntity();
        roles.add(roleEntity);
        userEntity.setRoles(roles);
        userRepos.save(userEntity);

        assertThat(userRepos.existsByUsername("rizky")).isTrue();
    }

    @Test
    void existsByUsernameNotFound() {

        assertThat(userRepos.existsByUsername("rizky")).isFalse();

    }

    @Test
    void existsByEmailFound() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("rizky");
        userEntity.setPassword("aa");
        userEntity.setEmail("riz@gmail.com");
        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity roleEntity = new RoleEntity();
        roles.add(roleEntity);
        userEntity.setRoles(roles);
        userRepos.save(userEntity);

        assertThat(userRepos.existsByEmail("riz@gmail.com")).isTrue();
    }

    @Test
    void existsByEmailNotFound() {

        assertThat(userRepos.existsByEmail("riz@gmail.com")).isFalse();

    }
}