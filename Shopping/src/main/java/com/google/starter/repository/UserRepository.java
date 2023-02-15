package com.google.starter.repository;

import com.google.starter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameAndPassword(String userName,String password);
    User findByUserName(String userName);
}
