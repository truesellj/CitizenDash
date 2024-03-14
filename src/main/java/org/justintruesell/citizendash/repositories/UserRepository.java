package org.justintruesell.citizendash.repositories;

import org.justintruesell.citizendash.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {
}
