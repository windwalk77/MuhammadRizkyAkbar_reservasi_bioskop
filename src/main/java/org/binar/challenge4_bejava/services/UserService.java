package org.binar.challenge4_bejava.services;

import org.binar.challenge4_bejava.models.entities.UserEntity;


import java.util.List;

public interface UserService {

    UserEntity addUser(UserEntity userEntity);
    void deleteUser(Long id);
    UserEntity updateUser(UserEntity user);
    UserEntity findUser(Long id);
    List<UserEntity> findAllUser();
}
