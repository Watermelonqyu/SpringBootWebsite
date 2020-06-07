package com.example.springboot.domain;

import com.example.springboot.domain.types.AuthorityType;
import javax.persistence.*;

/*
 * Authority
 */
@Entity
@Table(name = "authority")
public class Authority {
    
    /*
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /*
     * name
     */
    @Enumerated(EnumType.STRING)
    private final AuthorityType name;
    
    /*
     * constructer
     */
    public Authority(AuthorityType name) {
        this.name = name;
    }
    // getters and setters

    /*
     * id
     */
    public int getId() {
        return this.id;
    }

    /*
     * id
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
     * name
     */
    public AuthorityType getName() {
        return this.name;
    }
}