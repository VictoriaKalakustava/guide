package com.itransition.guide.controller;

import com.itransition.guide.converter.UserConverter;
import com.itransition.guide.dto.UserDTO;
import com.itransition.guide.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.itransition.guide.services.UserService;

import java.util.Optional;

//TODO make something with security

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/get-user")
public class GetUserController {

    @Autowired
    private UserService userService;

    @RequestMapping( params = {"login"}, method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUser(@RequestParam(value = "login") String login) {

        Optional<User> optional = userService.findByLogin(login);
        if(optional.isPresent()) {
            User user = optional.get();
            return new ResponseEntity<>(UserConverter.convert(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
