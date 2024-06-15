package cue.edu.co.PracticaSpringBoot.demo.controllers;

import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @GetMapping (value = "/get-user")
    public User getUser(){
        return User.builder()
                .name("Juan")
                .lastName("Peñuela")
                .phoneNumber(300)
                .password("Contra12345")
                .build();

    }
}