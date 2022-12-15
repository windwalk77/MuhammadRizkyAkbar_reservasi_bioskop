package com.binar.user.services;


import com.binar.user.models.entities.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity addUser(UserEntity userEntity);
    void deleteUser(Long id);
    UserEntity updateUser(UserEntity user);
    UserEntity findUser(Long id);
    List<UserEntity> findAllUser();
}
