package net.prodapp.springsecurityapp.service;

import net.prodapp.springsecurityapp.model.User;

/**
 *  Service class for {@link net.prodapp.springsecurityapp.model.User}
 * @author Maksym Mazur
 * @version 1.0
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
