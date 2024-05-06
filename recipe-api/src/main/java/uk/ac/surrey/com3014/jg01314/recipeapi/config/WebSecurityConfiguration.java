package uk.ac.surrey.com3014.jg01314.recipeapi.config;

import java.util.Arrays;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class WebSecurityConfiguration {

  private static final String API_ENDPOINTS_PATH = "/**";

  private final CorsConfigurationProperties corsConfigurationProperties;

  public WebSecurityConfiguration(CorsConfigurationProperties corsConfigurationProperties) {
    this.corsConfigurationProperties = corsConfigurationProperties;
  }

  @Bean
  public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
    http
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        .csrf(csrf -> csrf.ignoringRequestMatchers(API_ENDPOINTS_PATH))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(API_ENDPOINTS_PATH).permitAll()
            .anyRequest().authenticated()
        );
    return http.build();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    var configuration = new org.springframework.web.cors.CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList(corsConfigurationProperties.permittedUrls()));
    configuration.setAllowedMethods(Collections.singletonList("*"));
    configuration.setAllowedHeaders(Collections.singletonList("*"));
    configuration.setAllowCredentials(true);
    var source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration(API_ENDPOINTS_PATH, configuration);
    return source;
  }
}
