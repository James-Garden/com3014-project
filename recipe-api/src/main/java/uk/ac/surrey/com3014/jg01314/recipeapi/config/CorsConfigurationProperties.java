package uk.ac.surrey.com3014.jg01314.recipeapi.config;

import java.util.Arrays;
import java.util.Objects;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cors")
public record CorsConfigurationProperties(String[] permittedUrls) {

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CorsConfigurationProperties that = (CorsConfigurationProperties) o;
    return Objects.deepEquals(permittedUrls, that.permittedUrls);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(permittedUrls);
  }

  @Override
  public String toString() {
    return "CorsConfigurationProperties{" +
        "permittedUrls=" + Arrays.toString(permittedUrls) +
        '}';
  }
}
