package com.itransition.guide.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String image;
    private String about;

    private String login;
    private String password;

    private boolean isRole;
    private boolean isSex;
    private boolean isActivated;
}