package com.example.Oauth2Client.repository;

import com.example.Oauth2Client.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken1(String token);
}
