package com.itransition.guide.controller;

import com.itransition.guide.converter.UserConverter;
import com.itransition.guide.dto.UserDTO;
import com.itransition.guide.entity.User;
import com.itransition.guide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

//TODO make something with security

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/get-user")
public class GetUserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> getUser(@RequestBody String userc,HttpServletRequest request) {
        System.out.println(request);
        System.out.println(userc.split(":")[1].split("\"")[1]);
        Optional<User> optional = userService.findByLogin(userc.split(":")[1].split("\"")[1]);
        if(optional.isPresent()) {
            User user = optional.get();
            return new ResponseEntity<>(UserConverter.convert(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping( value="/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserGet(@PathVariable Long id) {
        Optional<User> optional = userService.findById(id);
        if(optional.isPresent()) {
            User user = optional.get();
            return new ResponseEntity<>(UserConverter.convert(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
