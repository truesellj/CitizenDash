package org.justintruesell.citizendash.services;
import org.justintruesell.citizendash.dto.UserDTO;
import org.justintruesell.citizendash.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public UserDetails loadUserByUsername(String userName);
    public void creat(UserDTO userDTO);
    public User findUserByEmail(String email);
    public User findUserByName(String name);
}
