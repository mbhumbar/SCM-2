package com.mbinfotechworld.SCM_2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbinfotechworld.SCM_2.entitiy.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

    Optional<User> findByEmail(String email);

}
