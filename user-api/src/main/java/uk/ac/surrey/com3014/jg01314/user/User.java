package uk.ac.surrey.com3014.jg01314.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String username;

  private String email;

  private String passwordHash;

  public User() {
  }

  public User(String username, String email, String passwordHash) {
    this.username = username;
    this.email = email;
    this.passwordHash = passwordHash;
  }

  public Integer getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public UserView asView() {
    return new UserView(id, username, email);
  }
}
