package com.example.registerlogin.controller;

import com.example.registerlogin.domain.entity.TblUser;
import com.example.registerlogin.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new TblUser());

        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(TblUser user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user).block();
//        Map<String, String> mstDvpUserAll =userRepo.findAll()
//                .collectMap(
//                        TblUser::getUsername,
//                        TblUser::getPassword
//                )
//                .defaultIfEmpty(Map.of("default","default@itrade.co.jp"))
//                .block();
//        log.info(mstDvpUserAll.toString());
        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<TblUser> listUsers = userRepo.findAll().collectList().block();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }
}