package com.rqbank.testspringboot.testspringboot.service;

import com.rqbank.testspringboot.testspringboot.domain.User;
import com.rqbank.testspringboot.testspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther Behnam Safari
 * date 10/10/18.
 * description
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findLikeUsername(String username) {
        return userRepository.findLikeUsername(username);
    }
}
