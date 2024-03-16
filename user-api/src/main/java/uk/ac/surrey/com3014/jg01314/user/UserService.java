package uk.ac.surrey.com3014.jg01314.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  User createUser(String username, String email, String password) {
    var hashedPassword = passwordEncoder.encode(password);
    var user = new User(username, email, hashedPassword);

    return userRepository.save(user);
  }
}
