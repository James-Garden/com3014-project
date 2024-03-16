package uk.ac.surrey.com3014.jg01314.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.ac.surrey.com3014.jg01314.validation.ValidationError;
import uk.ac.surrey.com3014.jg01314.validation.ValidationException;

@ExtendWith(MockitoExtension.class)
class UserValidatorTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserValidator userValidator;

  @Test
  void validateNewUser_AllValid_AssertDoesNotThrow() {
    var email = "john.smith@test.com";

    doReturn(false).when(userRepository).existsByEmail(email);

    assertDoesNotThrow(() -> userValidator.validateNewUser(
        "TestUsername", "john.smith@test.com", "Password123"
    ));
  }

  @Test
  void validateNewUser_AllFieldsNullOrBlank_AssertThrows() {
    var exception = assertThrows(
        ValidationException.class,
        () -> userValidator.validateNewUser("  ", "", null)
    );

    verifyNoInteractions(userRepository);

    assertThat(exception.getErrors())
        .extracting(ValidationError::field, ValidationError::message)
        .containsExactly(
            tuple(UserValidator.USERNAME_FIELD, "required"),
            tuple(UserValidator.EMAIL_FIELD, "required"),
            tuple(UserValidator.PASSWORD_FIELD, "required")
        );
  }

  @Test
  void validateNewUser_NonUniqueEmail_AssertThrows() {
    var email = "john.smith@test.com";

    doReturn(true).when(userRepository).existsByEmail(email);

    var exception = assertThrows(
        ValidationException.class,
        () -> userValidator.validateNewUser("TestUsername", email, "Password123")
    );

    assertThat(exception.getErrors())
        .extracting(ValidationError::field, ValidationError::message)
        .containsExactly(
            tuple(UserValidator.EMAIL_FIELD, "mustBeUnique")
        );
  }
}
