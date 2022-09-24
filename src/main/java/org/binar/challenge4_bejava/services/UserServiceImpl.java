package org.binar.challenge4_bejava.services;

import org.binar.challenge4_bejava.models.entities.UserEntity;
import org.binar.challenge4_bejava.models.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepos userRepos;

    @Override
    public UserEntity addUser(UserEntity user) {

        return userRepos.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepos.deleteById(id);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return userRepos.save(user);
    }

    @Override
    public UserEntity findUser(Long id) {
        Optional<UserEntity> user= userRepos.findById(id);
        return user.orElse(null);
    }

}
