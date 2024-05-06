package uk.ac.surrey.com3014.jg01314.recipeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class RecipeApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(RecipeApiApplication.class, args);
  }

}
