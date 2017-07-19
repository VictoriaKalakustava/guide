package com.itransition.guide.converter;

import com.itransition.guide.dto.UserDTO;
import com.itransition.guide.entity.User;

public class UserConverter {
    public static User convert(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getName());
        user.setLastName(dto.getSurname());
        user.setEmail(dto.getEmail());

        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());

        user.setIsActivated(dto.isActivated());
        return user;
    }

    public static UserDTO convert(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getFirstName());
        dto.setSurname(user.getLastName());
        dto.setEmail(user.getEmail());

        dto.setLogin(user.getLogin());
        dto.setPassword(user.getPassword());

        dto.setActivated(user.getIsActivated());
        return dto;
    }
}
