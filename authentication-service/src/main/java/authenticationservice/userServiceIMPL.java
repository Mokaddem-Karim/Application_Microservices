package com.linfsoft.authenticationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class userServiceIMPL {

    @Autowired
    private userRepository ur;

    public List<User> getAllUser() {
        return ur.findAll();
    }

}
