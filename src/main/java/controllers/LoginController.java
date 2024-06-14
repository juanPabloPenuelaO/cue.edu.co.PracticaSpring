package controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(String username, String password, Model model) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Aquí puedes agregar lógica para manejar sesiones
            return "redirect:/home"; // Redirige a la página de inicio
        } else {
            model.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        User registeredUser = userService.save(user);
        model.addAttribute("user", registeredUser);
        return "redirect:/login";
    }
}

