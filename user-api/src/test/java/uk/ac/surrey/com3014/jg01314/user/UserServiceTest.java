package uk.ac.surrey.com3014.jg01314.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private PasswordEncoder passwordEncoder;

  @InjectMocks
  private UserService userService;

  @Captor
  private ArgumentCaptor<User> argumentCaptor;

  @Test
  void createUser() {
    var username = "testUser";
    var email = "test@example.com";
    var password = "password";
    var hashedPassword = "hashed_password";
    var expectedUser = new User();

    when(passwordEncoder.encode(password)).thenReturn(hashedPassword);
    when(userRepository.save(any())).thenReturn(expectedUser);

    var user = userService.createUser(username, email, password);

    verify(userRepository).save(argumentCaptor.capture());

    assertThat(user).isEqualTo(expectedUser);
    assertThat(argumentCaptor.getValue()).extracting(
            User::getUsername,
            User::getEmail,
            User::getPasswordHash
        ).containsExactly(
            username,
            email,
            hashedPassword
        );
  }

}
