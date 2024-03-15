package uk.ac.surrey.com3014.jg01314.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfiguration {

  private static final PasswordEncoder PASSWORD_ENCODER =
      PasswordEncoderFactories.createDelegatingPasswordEncoder();

  @Bean
  public PasswordEncoder passwordEncoder() {
    return PASSWORD_ENCODER;
  }

}
