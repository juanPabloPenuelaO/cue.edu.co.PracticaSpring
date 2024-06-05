package cue.edu.co.PracticaSpringBoot.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/hello")
    public String test(Model model) {
        model.addAttribute("message", "hola, Mundo");
        return "hello";
    }
}
