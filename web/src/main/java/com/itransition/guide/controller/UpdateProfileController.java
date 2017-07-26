package com.itransition.guide.controller;


import com.itransition.guide.converter.UserConverter;
import com.itransition.guide.dto.UserDTO;
import com.itransition.guide.entity.User;
import com.itransition.guide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/update-user")
public class UpdateProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO dto) {
        if(userService.findByLogin(dto.getLogin()).isPresent()) {
            return new ResponseEntity<>(dto, HttpStatus.CONFLICT);
        }
        User user = UserConverter.convert(dto);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        UserDTO userFromDB = UserConverter.convert(userService.save(user));
        return new ResponseEntity<>(userFromDB, HttpStatus.OK);
    }
}
