package com.philippzeppelin.springboot.PP_3_1_1_springboot.dao;


import com.philippzeppelin.springboot.PP_3_1_1_springboot.models.User;

import java.util.List;

public interface UserDAO {
    List<User> showAllUsers();

    User showUser(int id);

    void saveUser(User user);

    void updateUser(int id, User updatedUser);

    void deleteUser(int id);
}