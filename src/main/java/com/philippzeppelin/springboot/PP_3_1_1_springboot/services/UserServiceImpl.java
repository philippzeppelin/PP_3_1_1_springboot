package com.philippzeppelin.springboot.PP_3_1_1_springboot.services;

import com.philippzeppelin.springboot.PP_3_1_1_springboot.dao.UserDAO;
import com.philippzeppelin.springboot.PP_3_1_1_springboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.showAllUsers();
    }

    @Override
    public User findOne(int id) {
        return userDAO.showUser(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    @Override
    public void update(int id, User updatedUser) {
        userDAO.updateUser(id, updatedUser);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.deleteUser(id);
    }
}