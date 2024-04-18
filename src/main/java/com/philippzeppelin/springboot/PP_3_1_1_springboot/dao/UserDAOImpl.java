package com.philippzeppelin.springboot.PP_3_1_1_springboot.dao;

import com.philippzeppelin.springboot.PP_3_1_1_springboot.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private final EntityManagerFactory entityManagerFactory;

    public UserDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<User> showAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        List<User> users = query.getResultList();
        entityManager.close();

        return users;
    }

    @Override
    public User showUser(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }

    @Override
    public void saveUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User userToUpdate = entityManager.find(User.class, id);
        userToUpdate.setName(updatedUser.getName());
        userToUpdate.setAge(updatedUser.getAge());
        userToUpdate.setEmail(updatedUser.getEmail());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteUser(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}