package uk.ac.surrey.com3014.jg01314.user;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.surrey.com3014.jg01314.validation.ValidationException;
import uk.ac.surrey.com3014.jg01314.validation.ValidationFailedResponse;

@RestController
@RequestMapping("/api/user")
class UserController {

  private final UserService userService;
  private final UserValidator userValidator;

  @Autowired
  UserController(UserService userService, UserValidator userValidator) {
    this.userService = userService;
    this.userValidator = userValidator;
  }

  @ExceptionHandler(ValidationException.class)
  ResponseEntity<ValidationFailedResponse> handleValidationException(ValidationException exception) {
    return ResponseEntity.badRequest().body(new ValidationFailedResponse(exception.getErrors()));
  }

  @PostMapping
  ResponseEntity<Void> createUser(@RequestBody CreateUserRequest request) throws ValidationException {
    userValidator.validateNewUser(request.username(), request.email(), request.password());

    var user = userService.createUser(request.username(), request.email(), request.password());
    var userResourceUri = URI.create("/api/user/" + user.getId());

    return ResponseEntity.created(userResourceUri).body(null);
  }

}
