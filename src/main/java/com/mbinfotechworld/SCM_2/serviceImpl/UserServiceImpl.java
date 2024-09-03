package com.mbinfotechworld.SCM_2.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbinfotechworld.SCM_2.entitiy.User;
import com.mbinfotechworld.SCM_2.repository.UserRepository;
import com.mbinfotechworld.SCM_2.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository  = userRepository;
    }


    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUser_id(userId);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public Optional<User> updateUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public boolean isUserExist(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isUserExist'");
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isUserExistByEmail'");
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserByEmail'");
    }


}
