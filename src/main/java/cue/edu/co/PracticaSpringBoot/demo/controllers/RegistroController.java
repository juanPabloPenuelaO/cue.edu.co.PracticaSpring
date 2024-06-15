package cue.edu.co.PracticaSpringBoot.demo.controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private UserService userService;

    @PostMapping("/nuevo")
    public ResponseEntity<String> registrarNuevoUsuario(@RequestBody User user) {
        if (user.getName() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Nombre de usuario y contraseña son obligatorios");
        }

        if (userService.findByUsername(user.getName()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El nombre de usuario ya está en uso");
        }

        userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");
    }
}
