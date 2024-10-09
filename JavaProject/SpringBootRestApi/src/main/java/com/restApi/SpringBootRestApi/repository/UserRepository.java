package com.restApi.SpringBootRestApi.repository;

import com.restApi.SpringBootRestApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByMobileNo(String mobileNo);
}
