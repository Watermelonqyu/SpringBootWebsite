
package com.example.springboot.repositories;

import com.example.springboot.domain.User;

import org.springframework.data.repository.CrudRepository;

/*
 * UserRepository
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByUsername(String username);
}