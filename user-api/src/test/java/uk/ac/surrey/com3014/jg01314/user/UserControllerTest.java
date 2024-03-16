package uk.ac.surrey.com3014.jg01314.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.testcontainers.shaded.org.apache.commons.lang3.reflect.FieldUtils;
import uk.ac.surrey.com3014.jg01314.AbstractIntegrationTest;
import uk.ac.surrey.com3014.jg01314.validation.ValidationError;
import uk.ac.surrey.com3014.jg01314.validation.ValidationException;
import uk.ac.surrey.com3014.jg01314.validation.ValidationFailedResponse;

@ExtendWith(MockitoExtension.class)
class UserControllerTest extends AbstractIntegrationTest {

  @MockBean
  private UserService userService;

  @MockBean
  private UserValidator userValidator;

  private final String username = "John";
  private final String email = "jsmith123@example.com";
  private final String password = "Password123";

  @Test
  void createUser_Valid_AssertCreated() throws IllegalAccessException {
    var user = new User(username, email, password);
    FieldUtils.writeField(user, "id", 1, true);
    var request = Map.of(
        UserValidator.USERNAME_FIELD, username,
        UserValidator.EMAIL_FIELD, email,
        UserValidator.PASSWORD_FIELD, password);

    when(userService.createUser(username, email, password)).thenReturn(user);

    var response = testRestTemplate.postForEntity(URI.create("/api/user"), request, Void.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getHeaders())
        .extracting(headers -> headers.get("Location"))
        .isEqualTo(Collections.singletonList("/api/user/" + user.getId()));
  }

  @Test
  void createUser_Invalid_AssertBadRequest() throws ValidationException {
    var request = Map.of(
        UserValidator.USERNAME_FIELD, username,
        UserValidator.EMAIL_FIELD, email,
        UserValidator.PASSWORD_FIELD, password);
    var errors = List.of(new ValidationError("someField", "someError"));

    doThrow(new ValidationException(errors)).when(userValidator).validateNewUser(username, email, password);


    var response = testRestTemplate.postForEntity("/api/user", request, ValidationFailedResponse.class);
    var validationFailedResponse = response.getBody();

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    assertThat(validationFailedResponse).isNotNull();
    assertThat(validationFailedResponse.errors()).isEqualTo(errors);
  }

}
