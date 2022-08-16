package com.example.AuthorizationServer.repository;

import com.example.AuthorizationServer.entity.TblUser;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<TblUser, Long> {

    Flux<TblUser> findAll();
    Mono<TblUser> findByEmail(String email);
}
