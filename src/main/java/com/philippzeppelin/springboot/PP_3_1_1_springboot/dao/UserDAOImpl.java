package com.philippzeppelin.springboot.PP_3_1_1_springboot.dao;

import com.philippzeppelin.springboot.PP_3_1_1_springboot.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        User userToUpdate = entityManager.find(User.class, id);
        userToUpdate.setName(updatedUser.getName());
        userToUpdate.setAge(updatedUser.getAge());
        userToUpdate.setEmail(updatedUser.getEmail());
        entityManager.merge(userToUpdate);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}