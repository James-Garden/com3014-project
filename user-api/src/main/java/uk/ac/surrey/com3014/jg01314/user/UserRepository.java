package uk.ac.surrey.com3014.jg01314.user;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<User, Integer> {

  boolean existsByEmail(String email);

  Optional<User> findByEmail(String email);

}
