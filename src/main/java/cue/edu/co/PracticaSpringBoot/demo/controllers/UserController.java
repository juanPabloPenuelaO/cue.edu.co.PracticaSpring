package cue.edu.co.PracticaSpringBoot.demo.controllers;

import cue.edu.co.PracticaSpringBoot.demo.model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @GetMapping (value = "/get-user")
    public model getUser(){
        return model.builder()
                .id("1")
                .name("Juan")
                .age(33)
                .cellphone("3009822408")
                .email("jpenuela2229@cue.edu.co")
                .build();

    }
}
