package one.tsv.Prak23;


import one.tsv.Prak23.models.User;
import one.tsv.Prak23.repositories.UserRepository;
import one.tsv.Prak23.services.AuthorizationService;
import one.tsv.Prak23.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;


@ExtendWith(MockitoExtension.class)
public class AuthorizationServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    PasswordEncoder passwordEncoder;

    @Test
    void signup(){
        UserService userService = new UserService(userRepository);

        User user1 = new User("John", "12345", User.Role.USER);
        User user2 = new User("Janne", "54321", User.Role.USER);
        User user3 = new User("Joseph", "abc", User.Role.USER);

        Mockito.when(userRepository.existsByUsername("John")).thenReturn(true);
        Mockito.when(userRepository.existsByUsername("Joseph")).thenReturn(false);

        Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenAnswer(invocation -> invocation.getArgument(0));

        AuthorizationService authorizationService = new AuthorizationService(passwordEncoder, userService);

        Assertions.assertFalse(authorizationService.signUp(user1));
        Assertions.assertTrue(authorizationService.signUp(user3));
    }
}