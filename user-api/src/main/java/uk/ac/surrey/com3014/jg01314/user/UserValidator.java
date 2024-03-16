package uk.ac.surrey.com3014.jg01314.user;

import io.micrometer.common.util.StringUtils;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.surrey.com3014.jg01314.validation.ValidationError;
import uk.ac.surrey.com3014.jg01314.validation.ValidationException;

@Service
class UserValidator {

  static final String USERNAME_FIELD = "username";
  static final String EMAIL_FIELD = "email";
  static final String PASSWORD_FIELD = "password";

  private final UserRepository userRepository;

  @Autowired
  UserValidator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  void validateNewUser(String username, String email, String password) throws ValidationException {
    var errors = new ArrayList<ValidationError>();

    validateUsername(username).ifPresent(errors::add);
    validateEmail(email).ifPresent(errors::add);
    validatePassword(password).ifPresent(errors::add);

    if (errors.isEmpty()) {
      return;
    }

    throw new ValidationException(errors);
  }

  private Optional<ValidationError> validateUsername(String username) {
    return validateNotBlank(USERNAME_FIELD, username);
  }

  private Optional<ValidationError> validateEmail(String email) {
    var blankErrorOptional = validateNotBlank(EMAIL_FIELD, email);
    if (blankErrorOptional.isPresent()) {
      return blankErrorOptional;
    }

    return userRepository.existsByEmail(email)
        ? Optional.of(new ValidationError(EMAIL_FIELD, "mustBeUnique"))
        : Optional.empty();
  }

  private Optional<ValidationError> validatePassword(String password) {
    return validateNotBlank(PASSWORD_FIELD, password);
  }

  private Optional<ValidationError> validateNotBlank(String field, String value) {
    return StringUtils.isBlank(value)
        ? Optional.of(new ValidationError(field, "required"))
        : Optional.empty();
  }
}
