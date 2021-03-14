package net.prodapp.springsecurityapp.service;

/**
 * Service for Security.
 * @author Maksym Mazur
 * @version 1.0
 */
public interface SecurityService {

    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
