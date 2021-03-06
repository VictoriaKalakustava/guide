package com.itransition.guide.services;

import com.itransition.guide.entity.User;
import com.itransition.guide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Transactional
    public User save(User user){
        return userRepository.saveAndFlush(user);
    }

    public Optional<User> findByLogin(String login) {
        return Optional.ofNullable(userRepository.findByLogin(login));
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userRepository.findById(id));
    }

    public Optional<User> findUserByKey(String key) {
        return Optional.ofNullable(userRepository.getUserByEnableKey(key));
    }
}
