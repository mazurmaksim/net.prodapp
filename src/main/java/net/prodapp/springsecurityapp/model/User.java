package net.prodapp.springsecurityapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 *  Simple JavaBean object that represents a User.
 *
 * @author  Maksym Mazur
 * @version 1.0
 * https://www.youtube.com/watch?v=iivY8B5A0Tk&ab_channel=EugeneSuleimanov
 */

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="user_name")
    private String username;

    @Column(name ="password")
    private String password;

    @Transient
    transient private String confirmPassword;

    @ManyToMany
    @JoinTable(name="user_roles", joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;
}
