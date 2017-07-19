package com.itransition.guide.controller;

import com.itransition.guide.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "", method= RequestMethod.GET)
    public ResponseEntity<User> myMethod() {

        System.out.println("Test controller");
        User user = new User();
        user.setFirstName("Vasya");
        user.setLastName("Pupkin");
        System.out.println("Test controller");
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
