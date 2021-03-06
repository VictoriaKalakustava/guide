package com.itransition.guide.entity;

import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Indexed
@Entity
public class User implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private String login;
    private String password;
    private boolean sex;
    private String about;
    private String image;
    private boolean role;
    private List<Instruction> instructions;

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

    @Column(name = "sex", nullable = true, insertable = true, updatable = true)
    public boolean getSex() {return sex; }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Column(name = "about", nullable = true, insertable = true, updatable = true)
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Column(name = "image", nullable = true, insertable = true, updatable = true)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "lastName", nullable = true, insertable = true, updatable = true)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "role", nullable = false, insertable = true, updatable = true)
    public boolean getRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    @Column(name = "email", nullable = true, insertable = true, updatable = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Field
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

    @ContainedIn
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }
}
