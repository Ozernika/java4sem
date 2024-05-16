package one.tsv.Prak23.services;

import lombok.AllArgsConstructor;
import one.tsv.Prak23.models.User;
import one.tsv.Prak23.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public boolean create(one.tsv.Prak23.models.User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return false;
        }else{
            userRepository.save(user);
            return true;
        }
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }
}