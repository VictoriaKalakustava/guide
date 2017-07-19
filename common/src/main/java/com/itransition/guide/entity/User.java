package com.itransition.guide.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private String login;
    private String password;
    private String sex;
    private String about;
    private String image;
    private String role;

    private boolean isActivated;
    private String enableKey;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false, insertable = true, updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = true, insertable = true, updatable = true)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName", nullable = false, insertable = true, updatable = true)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = true, insertable = true, updatable = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "login", nullable = false, insertable = true, updatable = true)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password", nullable = false, insertable = true, updatable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "is_activated", nullable = false, insertable = true, updatable = true)
    public boolean getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    @Column(name = "enable_key", nullable = true, insertable = true, updatable = true)
    public String getEnableKey() {
        return enableKey;
    }

    public void setEnableKey(String enableKey) {
        this.enableKey = enableKey;
    }

}
