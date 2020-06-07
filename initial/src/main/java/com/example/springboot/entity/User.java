
package com.example.springboot.entity;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "user")
public class User implements Serializable {
    
    /*
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /*
     * username
     */
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;
    
    /*
     * password
     */
    @NotEmpty
    private String password;
    private Date dateCreated;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_id") })
    private Set<Authority> authorities = new HashSet<>();
    public User() {
    }
    // getters and setters
}