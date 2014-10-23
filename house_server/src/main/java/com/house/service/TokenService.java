package com.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.KeyBasedPersistenceTokenService;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.house.model.User;
import com.house.security.RegisterUserDetails;


@Service("appTokenService")
public class TokenService {
    @Autowired
    private KeyBasedPersistenceTokenService tokenService;
    
    @Autowired
    private UserService userService;
    
    public String getToken(User user){
        String preToToken = user.getUsrId() + "=" + user.getUsrPw();
        Token token = tokenService.allocateToken(preToToken);
        return token.getKey();
    }
    
    public boolean validate(String token) {
        Token verifyToken = null;
        try {
            verifyToken = tokenService.verifyToken(token);
        }catch (IllegalArgumentException e){
            return false;
        }
        String[] information = null;
        try {
        	information = verifyToken.getExtendedInformation().split("=");
        } catch(NullPointerException e){
        	return false;
        }
        User user = userService.getUserById(information[0]);
        if(user == null){
            return false;
        }
        if(user.getUsrPw().equals(information[1])){
            return true;
        }
        return false;
    }
    
    public UserDetails getUserFromToken(String token) {
        Token verifyToken = tokenService.verifyToken(token);
        String[] information = verifyToken.getExtendedInformation().split("=");
        User user = userService.getUserById(information[0]);
        
        RegisterUserDetails userDetails = new RegisterUserDetails(user);
        return userDetails;
    }
}
