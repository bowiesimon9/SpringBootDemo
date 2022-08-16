package com.example.Oauth2Client.repository;

import com.example.Oauth2Client.entity.TblUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<TblUser, Long> {

    List<TblUser> findAll();
    Optional<TblUser> findByEmail(String email);
}
