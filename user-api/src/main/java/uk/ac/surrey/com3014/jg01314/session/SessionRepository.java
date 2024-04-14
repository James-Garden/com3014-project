package uk.ac.surrey.com3014.jg01314.session;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

interface SessionRepository extends CrudRepository<Session, String> {

  boolean existsById(@NonNull String id);

}
