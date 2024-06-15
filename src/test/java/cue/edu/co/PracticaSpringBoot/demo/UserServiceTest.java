package cue.edu.co.PracticaSpringBoot.demo;

import model.User;
import repository.userImpl.UserRepositoryJDBC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepositoryJDBC userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1);
        user.setName("Juan");
        user.setLastName("Penuela");
        user.setPhoneNumber(123456789);
        user.setPassword("1234");

        when(userRepository.findByUsername("juanpenuela")).thenReturn(user);
        doNothing().when(userRepository).save(any(User.class));
    }

    @Test
    void testFindByUsername() {
        User foundUser = userService.findByUsername("juanpenuela");

        assertEquals("juan", foundUser.getName());
        assertEquals("penuela", foundUser.getLastName());
        assertEquals(123456789, foundUser.getPhoneNumber());
        assertEquals("1234", foundUser.getPassword());
        verify(userRepository, times(1)).findByUsername("juanpenuela");
    }

    @Test
    void testSave() {
        User newUser = new User();
        newUser.setName("Monica");
        newUser.setLastName("Tobon");
        newUser.setPhoneNumber(999999);
        newUser.setPassword("contra123");
        User savedUser = userService.save(newUser);

        assertEquals("Monica", savedUser.getName());
        assertEquals("Tobon", savedUser.getLastName());
        assertEquals(999999, savedUser.getPhoneNumber());
        assertEquals("contra123", savedUser.getPassword());

        verify(userRepository, times(1)).save(any(User.class));
    }
}
