package org.binar.challenge4_bejava.services;

import org.binar.challenge4_bejava.models.entities.RoleEntity;
import org.binar.challenge4_bejava.models.entities.UserEntity;
import org.binar.challenge4_bejava.models.repos.UserRepos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepos userRepos;
    @InjectMocks
    private UserServiceImpl userService;


    @Test
    void addUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("rizky");
        userEntity.setPassword("aa");
        userEntity.setEmail("riz@gmail.com");
        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity roleEntity = new RoleEntity();
        roles.add(roleEntity);
        userEntity.setRoles(roles);
        userService.addUser(userEntity);

        ArgumentCaptor<UserEntity> userEntityArgumentCaptor = ArgumentCaptor.forClass(UserEntity.class);
        verify(userRepos).save(userEntityArgumentCaptor.capture());

        UserEntity captureUser = userEntityArgumentCaptor.getValue();
        assertThat(captureUser).isEqualTo(userEntity);
    }

    @Test
    void deleteUser() {
        userService.deleteUser(1L);
        verify(userRepos).deleteById(1L);
    }

    @Test
    void updateUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setIdUser(1L);
        userEntity.setUsername("rizky");
        userEntity.setPassword("aa");
        userEntity.setEmail("riz@gmail.com");
        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity roleEntity = new RoleEntity();
        roles.add(roleEntity);
        userEntity.setRoles(roles);
        userService.updateUser(userEntity);

        ArgumentCaptor<UserEntity> userEntityArgumentCaptor = ArgumentCaptor.forClass(UserEntity.class);
        verify(userRepos).save(userEntityArgumentCaptor.capture());

        UserEntity captureUser = userEntityArgumentCaptor.getValue();
        assertThat(captureUser).isEqualTo(userEntity);
    }

    @Test
    void findUser() {
        userService.findUser(1L);
        verify(userRepos).findById(1L);
    }

    @Test
    void findAllUser() {
        userService.findAllUser();
        verify(userRepos).findAll();
    }
}