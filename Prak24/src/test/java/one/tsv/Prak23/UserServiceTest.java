package one.tsv.Prak23;

import one.tsv.Prak23.models.User;
import one.tsv.Prak23.repositories.UserRepository;
import one.tsv.Prak23.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;



@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void create(){
        User user1 = new User("John", "12345", User.Role.USER);
        User user2 = new User("Janne", "54321", User.Role.USER);

        User user3 = new User("Joseph", "abc", User.Role.USER);

        Mockito.when(userRepository.existsByUsername("John")).thenReturn(true);
        Mockito.when(userRepository.existsByUsername("Joseph")).thenReturn(false);

        UserService userService = new UserService(userRepository);

        Assertions.assertFalse(userService.create(user1));
        Assertions.assertTrue(userService.create(user3));
    }
    @Test
    void find(){
        User user1 = new User("John", "12345", User.Role.USER);
        User user2 = new User("Janne", "54321", User.Role.USER);

        User user3 = new User("Joseph", "abc", User.Role.USER);

        Mockito.when(userRepository.findByUsername("John")).thenReturn(Optional.of(user1));
        Mockito.when(userRepository.findByUsername("Joseph")).thenReturn(Optional.empty());

        UserService userService = new UserService(userRepository);

        Assertions.assertEquals(userService.getByUsername("John"), user1);
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {userService.getByUsername("Joseph");});
    }
}