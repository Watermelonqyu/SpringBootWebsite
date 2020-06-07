
package com.example.springboot.domain;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/*
 * User
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    
    /*
     * serialVersionUID
     */
    static final long serialVersionUID = 1L;

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
    
    /*
     * dateCreated
     */
    private Date dateCreated;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_id") })
    private transient Set<Authority> authorities = new HashSet<>();
    
    /*
     * constructer
     */
    public User() {

    }
    // getters and setters

    /*
     * getUsername
     */
    public String getUsername() {
        return this.username;
    }

    /*
     * setUsername
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /*
     * getPassword
     */
    public String getPassword() {
        return this.password;
    }

    /*
     * setPassword
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /*
     * getId
     */
    public int getId() {
        return this.id;
    }

    /*
     * setId
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
     * getAuthorities
     */
    public Set<Authority> getAuthorities() {
        return this.authorities;
    }

    /*
     * getAuthorities
     */
    public void getAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    /*
     * getDateCreated
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /*
     * setDateCreated
     */
    public void setDateCreated() {
        this.dateCreated = new Date();
    }
}