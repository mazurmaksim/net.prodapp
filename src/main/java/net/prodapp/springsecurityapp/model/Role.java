package net.prodapp.springsecurityapp.model;

import lombok.Data;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Set;

/**
 *  Simple JavaBean object that represents role of {@link User}
 *
 * @author  Maksym Mazur
 * @version 1.0
 * https://www.youtube.com/watch?v=iivY8B5A0Tk&ab_channel=EugeneSuleimanov
 */

@Entity
@Data
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
