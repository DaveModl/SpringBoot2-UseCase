package com.thymeleaf.repository;

import com.thymeleaf.entity.User;

import java.util.List;

public interface UserRepository {

    User saveOrUpdateUser(User user);
    void deleteUserById(Long id);
    User getUserById(Long id);
    List<User> allUsers();
}
