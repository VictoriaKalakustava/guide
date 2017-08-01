package com.itransition.guide.repository;

import com.itransition.guide.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    User getUserByEnableKey(String key);
    User findById(Long id);
}
