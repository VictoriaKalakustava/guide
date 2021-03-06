package com.itransition.guide.controller;

import com.itransition.guide.converter.UserConverter;
import com.itransition.guide.dto.UserDTO;
import com.itransition.guide.email.CustomEmailSender;
import com.itransition.guide.entity.User;
import com.itransition.guide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/sign-up")
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomEmailSender sender;

    private final static String PREFIX = "localhost:8080/sign-up/enable?key=";

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO dto) {
        System.out.println(dto);
        if(userService.findByLogin(dto.getLogin()).isPresent()) {
            return new ResponseEntity<>(dto, HttpStatus.CONFLICT);
        }
        System.out.println(dto);
        User user = UserConverter.convert(dto);
        String key = generateActivationKey(user.getId());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnableKey(key);
        UserDTO userFromDB = UserConverter.convert(userService.save(user));
        sender.sendEmail(userFromDB.getEmail(), "Account activation", PREFIX + key);
        return new ResponseEntity<>(userFromDB, HttpStatus.OK);
    }

    @RequestMapping(value = "/login/is-exist", method = RequestMethod.POST)
    public ResponseEntity<Boolean> isLoginExist(@RequestBody String login) {
        if(userService.findByLogin(login).isPresent()) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.OK);
    }

//    @RequestMapping(value = "/enable", params = {"key"}, method = RequestMethod.GET)
//    public ModelAndView enableAccount(@RequestParam(value = "key") String key) {
//        ModelAndView model = new ModelAndView();
//        Optional<User> optional = userService.findUserByKey(key);
//        if(optional.isPresent()) {
//            model.setViewName("redirect:/logout");
//            User user = optional.get();
//            user.setEnableKey(null);
//            user.setIsActivated(true);
//            userService.save(user);
//        } else {
//            model.setViewName("redirect:/used-link");
//        }
//
//        return model;
//    }

    private String generateActivationKey(Long id) {
        return new BCryptPasswordEncoder().encode(getSaltString() + id);
    }

    private String getSaltString() {
        final String SALT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALT_CHARS.length());
            salt.append(SALT_CHARS.charAt(index));
        }
        return salt.toString();
    }
}
