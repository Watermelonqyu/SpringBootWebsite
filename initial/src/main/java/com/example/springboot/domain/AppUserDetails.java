package com.example.springboot.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.stream.Collectors;

/*
 * AppUserDetails
 */
public class AppUserDetails implements UserDetails {
    /*
     * serialVersionUID
     */
    static final long serialVersionUID = 1L;

    /*
     * User
     */
    private transient User user;

    /*
     * Constructor
     */
    public AppUserDetails(User user) {
        this.user = user;
    }

    /*
     * getAuthorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities().stream().map(authority -> new SimpleGrantedAuthority(authority.getName().toString())).collect(Collectors.toList());
    }

    /*
     * getId
     */
    public int getId() {
        return user.getId();
    }

    /*
     * getPassword
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /*
     * getUsername
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /*
     * isAccountNonExpired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /*
     * isAccountNonLocked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /*
     * isCredentialsNonExpired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /*
     * isEnabled
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /*
     * getUserDetails
     */
    public User getUserDetails() {
        return user;
    }
}