package org.binar.challenge4_bejava.services;

import org.binar.challenge4_bejava.models.entities.UserEntity;
import org.binar.challenge4_bejava.models.repos.UserRepos;

public interface UserService {

    UserEntity addUser(UserEntity userEntity);
    void deleteUser(Long id);
    UserEntity updateUser(UserEntity user);
    UserEntity findUser(Long id);
}
