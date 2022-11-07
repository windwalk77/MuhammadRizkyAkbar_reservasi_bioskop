package org.binar.challenge4_bejava.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.binar.challenge4_bejava.models.entities.UserEntity;
import org.binar.challenge4_bejava.models.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepos userRepos;


    @Override
    public UserEntity addUser(UserEntity user) {
        log.info("Succesfully Add User");
        return userRepos.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Succesfully Delete User");
        userRepos.deleteById(id);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        log.info("Succesfully Update User");
        return userRepos.save(user);
    }

    @Override
    public UserEntity findUser(Long id) {
        log.info("Succesfully Find User");
        Optional<UserEntity> user= userRepos.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<UserEntity> findAllUser() {
        log.info("Succesfully Find All User");
        return userRepos.findAll();
    }

}
