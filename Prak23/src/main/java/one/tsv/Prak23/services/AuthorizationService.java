package one.tsv.Prak23.services;

import lombok.AllArgsConstructor;
import one.tsv.Prak23.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static one.tsv.Prak23.models.User.Role.USER;


@AllArgsConstructor
@Service
public class AuthorizationService {
    PasswordEncoder passwordEncoder;
    private final UserService userService;

    public boolean signUp(User userData) {

        User user = new User(userData.getUsername(), passwordEncoder.encode(userData.getPassword()), USER);

        return userService.create(user);
    }
}