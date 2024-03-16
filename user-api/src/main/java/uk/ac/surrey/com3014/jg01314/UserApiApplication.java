package uk.ac.surrey.com3014.jg01314;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class UserApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserApiApplication.class, args);
  }

}
