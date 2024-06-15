package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.userImpl.UserRepositoryJDBC;

@Service
public class UserService {

    @Autowired
    private UserRepositoryJDBC userRepository;

    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public User save(User user) {
        userRepository.save(user);
        return user;
    }
}

