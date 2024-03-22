package org.justintruesell.citizendash.repositories;

import org.justintruesell.citizendash.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Wonder if I should use CRUDRepository here instead of JPA
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByEmail(String email);
    public User findUserByUserName(String name);
}
