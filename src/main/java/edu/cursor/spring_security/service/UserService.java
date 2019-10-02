package edu.cursor.spring_security.service;

import edu.cursor.spring_security.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);

    User updateUser(User user);

    List<User> findAllUsers();

    Optional<User> getUserById(Long id);

    Optional<User> findByUsername(String userName);

    boolean existsByUsername(String userName);

    void deleteByUserName(String userName);
}
