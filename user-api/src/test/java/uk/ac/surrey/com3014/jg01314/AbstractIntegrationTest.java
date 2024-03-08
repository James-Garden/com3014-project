package uk.ac.surrey.com3014.jg01314;


import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * Helper class which starts up the entire app, but allows parts of it to be mocked for better
 * integration testing
 */
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = {AbstractIntegrationTest.Initializer.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@DirtiesContext
public abstract class AbstractIntegrationTest {

  @SuppressWarnings("resource")
  @Container
  private static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER =
      new PostgreSQLContainer<>("postgres:latest")
          .withDatabaseName("integration_test_db")
          .withUsername("test_username")
          .withPassword("test");

  @Autowired
  protected EntityManager entityManager;

  @Autowired
  protected TestRestTemplate testRestTemplate;

  static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      TestPropertyValues.of(
          "spring.datasource.url=" + POSTGRE_SQL_CONTAINER.getJdbcUrl(),
          "spring.datasource.username=" + POSTGRE_SQL_CONTAINER.getUsername(),
          "spring.datasource.password=" + POSTGRE_SQL_CONTAINER.getPassword()
      ).applyTo(configurableApplicationContext.getEnvironment());
    }
  }
}
