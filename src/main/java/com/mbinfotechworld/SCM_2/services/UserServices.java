package com.mbinfotechworld.SCM_2.services;

import java.util.Optional;
import java.util.*;

import com.mbinfotechworld.SCM_2.entitiy.User;

public interface UserServices {

    User saveUser(User user);

    Optional<User> getUserById(String id);

    Optional<User> updateUser(User user);

    void deleteUser(String id);

    boolean isUserExist(String id);

    boolean isUserExistByEmail(String email);

    List<User> getAllUsers();

    Optional<User> getUserByEmail(String email); 
} 
