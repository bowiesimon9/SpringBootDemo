package com.example.registerlogin.domain.repository;

import com.example.registerlogin.domain.entity.TblUser;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface UserRepository extends R2dbcRepository<TblUser, Long> {

    Flux<TblUser> findAll();
    Mono<TblUser> findByUsername(String username);
}
