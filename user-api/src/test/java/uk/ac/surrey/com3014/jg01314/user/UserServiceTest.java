package uk.ac.surrey.com3014.jg01314.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

  @Test
  void findById() {
    var user = UserTestUtil.userWithId();

    when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

    var foundUserOptional = userService.findById(user.getId());

    assertThat(foundUserOptional).contains(user);
  }

  @Test
  void findByEmail() {
    var user = UserTestUtil.userWithId();

    when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

    var foundUserOptional = userService.findByEmail(user.getEmail());

    assertThat(foundUserOptional).contains(user);
  }

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void verifyPassword(boolean shouldVerify) {
    var user = UserTestUtil.userWithId();
    var password = "test123";

    when(passwordEncoder.matches(password, user.getPasswordHash()))
        .thenReturn(shouldVerify);

    var isVerified = userService.verifyPassword(user, password);

    assertThat(isVerified).isEqualTo(shouldVerify);
  }
}
