package uk.ac.surrey.com3014.jg01314.user;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  User createUser(String username, String email, String password) {
    var hashedPassword = passwordEncoder.encode(password);
    var user = new User(username, email, hashedPassword);

    return userRepository.save(user);
  }

  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public boolean verifyPassword(User user, String password) {
    return passwordEncoder.matches(password, user.getPasswordHash());
  }
}
