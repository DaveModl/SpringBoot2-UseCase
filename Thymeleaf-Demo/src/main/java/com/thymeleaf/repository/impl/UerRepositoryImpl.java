package com.thymeleaf.repository.impl;

import com.thymeleaf.entity.User;
import com.thymeleaf.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UerRepositoryImpl implements UserRepository {
    private static AtomicLong iDCounter = new AtomicLong();
    private final ConcurrentMap<Long,User> userDb = new ConcurrentHashMap<>();
    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if (id == null){
            id = iDCounter.incrementAndGet();
            user.setId(id);
        }
        this.userDb.put(id,user);
        return user;
    }

    @Override
    public void deleteUserById(Long id) {
        this.userDb.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return this.userDb.get(id);
    }

    @Override
    public List<User> allUsers() {
        return new ArrayList<>(this.userDb.values());
    }

}
