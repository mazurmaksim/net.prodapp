package net.prodapp.springsecurityapp.service;

import net.prodapp.springsecurityapp.dao.RoleDao;
import net.prodapp.springsecurityapp.dao.UserDao;
import net.prodapp.springsecurityapp.model.Role;
import net.prodapp.springsecurityapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 *  Implementation of {@link UserService} interface.
 * @author Maksym Mazur
 * @version 1.0
 */

@Service
public class UserServiseImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles((roles));
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
