package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.userImpl.UserRepositoryJDBC;

@Service
public class UserService {

    @Autowired
    private UserRepositoryJDBC userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        // Puedes implementar lógica para cifrar la contraseña aquí si lo deseas
        userRepository.save(user);
        return user;
    }
}
