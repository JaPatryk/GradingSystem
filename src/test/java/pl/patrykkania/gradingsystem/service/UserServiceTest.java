package pl.patrykkania.gradingsystem.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.patrykkania.gradingsystem.model.User;
import pl.patrykkania.gradingsystem.repository.UserRepository;
import pl.patrykkania.gradingsystem.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;



    @Test
    public void testLoadUserByUsername_UserNotFound() {

        String userEmail = "nonexistent@example.com";


        when(userRepository.findByEmail(userEmail)).thenReturn(Optional.empty());


        UsernameNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            userService.loadUserByUsername(userEmail);
        });


        assertThat(exception.getMessage()).isEqualTo("User not found with email: " + userEmail);
    }

    @Test
    public void testGetUserByEmail() {

        String userEmail = "user@example.com";
        User user = new User();


        when(userRepository.findByEmail(userEmail)).thenReturn(Optional.of(user));


        Optional<User> result = userService.getUserByEmail(userEmail);

        assertThat(result).isEqualTo(Optional.of(user));
    }
}
