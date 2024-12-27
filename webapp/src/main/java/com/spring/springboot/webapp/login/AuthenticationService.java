package com.spring.springboot.webapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username,String password){

        boolean isValidUsername = username.equalsIgnoreCase("anurag");
        boolean isValidPassword = password.equalsIgnoreCase("anurag");
        return isValidUsername && isValidPassword;
    }
}
