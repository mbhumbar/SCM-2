package com.mbinfotechworld.SCM_2.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbinfotechworld.SCM_2.entitiy.User;
import com.mbinfotechworld.SCM_2.helpers.ResourcesNotFoundException;
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
     return userRepository.findById(id);  
    }

    @Override
    public Optional<User> updateUser(User user) {
         User userData  = userRepository.findById(user.getUser_id())
         .orElseThrow(() -> new ResourcesNotFoundException("User Not Found.."));
         // update the user
         userData.setUserName(user.getUserName());
         userData.setEmail(user.getEmail());
         userData.setPassword(user.getPassword());
         userData.setPhoneNo(user.getPhoneNo());
         userData.setProfilePic(user.getProfilePic());
         userData.setEnable(user.isEnable());
         userData.setProviders(user.getProviders());
         userData.setProviderUserId(user.getProviderUserId());
        User save = userRepository.save(userData);
        return Optional.ofNullable(save);
    }


    @Override
    public void deleteUser(String id) {
        User userdata = userRepository.findById(id)
        .orElseThrow(() -> new ResourcesNotFoundException("User not found"));
        userRepository.delete(userdata);
    }

    @Override
    public boolean isUserExist(String id) {
       User user = userRepository.findById(id).orElse(null);
        return user != null ? true:false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        return user != null ? true:false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email).orElse(null));
    }
}
