package uk.ac.surrey.com3014.jg01314.config;

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
    configuration.setAllowedOrigins(Collections.singletonList("*"));
    configuration.setAllowedMethods(Collections.singletonList("*"));
    configuration.setAllowedHeaders(Collections.singletonList("*"));
    var source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration(API_ENDPOINTS_PATH, configuration);
    return source;
  }
}
