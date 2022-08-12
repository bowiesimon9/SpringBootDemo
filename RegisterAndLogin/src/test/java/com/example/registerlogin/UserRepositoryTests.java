package com.example.registerlogin;

import com.example.registerlogin.domain.entity.TblUser;
import com.example.registerlogin.domain.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;

import java.util.Map;

@DataR2dbcTest
public class UserRepositoryTests {
    private static final Logger log = LoggerFactory.getLogger(UserRepositoryTests.class);
    @Autowired
    UserRepository realDeposit;

    @Test
    @DisplayName("findAll->正常")
    public void findAll() {

        log.info("Address found with findDAMSAddress():");
        log.info("-------------------------------");
        Map<String, String> mstDvpUserAll =realDeposit.findAll()
                .collectMap(
                        TblUser::getUsername,
                        TblUser::getPassword
                )
                .defaultIfEmpty(Map.of("default","default@itrade.co.jp"))
                .block();
        log.info(mstDvpUserAll.toString());
    }
}
