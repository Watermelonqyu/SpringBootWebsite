
package com.example.springboot.repositories.impl;

import java.util.*;

import com.example.springboot.domain.User;
import com.example.springboot.repositories.UserRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/*
 * UserRepositoryImpl
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    /*
     * sessionFactory
     */
    @Autowired
    private static SessionFactory sessionFactory;

    /*
     * getUserByUsername
     */
    @Override
    public User getUserByUsername(String username) {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("FROM User u where u.username=:username", User.class);
        query.setParameter("username", username);
        return query.uniqueResult();
    }

    /*
     * existsById
     */
    @Override 
    public boolean existsById(Integer id) {
        return true;
    }

    /*
     * count
     */
    @Override 
    public long count() {
        return 1L;
    }

    /*
     * deleteById
     */
    @Override
    public void deleteById(Integer id) {
        return;
    }

    /*
     * delete
     */
    @Override
    public void delete(User user) {
        return;
    }

    /*
     * deleteAll with parameter
     */
    @Override
    public void deleteAll(Iterable<? extends User> entities) {
        return;
    }

    /*
     * deleteAll
     */
    @Override
    public void deleteAll() {
        return;
    }

    /*
     * findAll
     */
    @Override
    public Iterable<User> findAll() {
        return null;
    }

    /*
     * findAllById
     */
    @Override
    public Iterable<User> findAllById(Iterable<Integer> ids) {
        return null;
    }

    /*
     * findById
     */
    @Override
    public Optional<User> findById(Integer id) {
        return null;
    }

    /*
     * save
     */
    @Override
    public User save(User user) {
        return null;
    }

    /*
     * saveAll
     */
    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> users) {
        return null;
    }
}