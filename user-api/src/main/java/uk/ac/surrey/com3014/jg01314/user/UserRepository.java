package uk.ac.surrey.com3014.jg01314.user;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<User, Integer> {

  boolean existsByEmail(String email);

}
