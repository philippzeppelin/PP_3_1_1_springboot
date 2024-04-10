package com.philippzeppelin.springboot.PP_3_1_1_springboot.services;


import com.philippzeppelin.springboot.PP_3_1_1_springboot.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);
}