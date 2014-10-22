package com.house.service;

import com.house.model.User;
import com.house.security.RegisterUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.KeyBasedPersistenceTokenService;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service("tokenService")
public class TokenService {
	@Autowired
	private KeyBasedPersistenceTokenService originTokenService;
	@Autowired
	private UserService userService;

	public String getToken(User user) {
		String preToToken = user.getUsrId() + "=" + user.getUsrPw();
		Token token = this.originTokenService.allocateToken(preToToken);
		return token.getKey();
	}

	public boolean validate(String token) {
		Token verifyToken = null;
		try {
			verifyToken = this.originTokenService.verifyToken(token);
		} catch (IllegalArgumentException e) {
			return false;
		}
		String[] information = null;
		try {
			information = verifyToken.getExtendedInformation().split("=");
		} catch (NullPointerException e) {
			return false;
		}
		User user = this.userService.getUserById(information[0]);
		if (user == null) {
			return false;
		}
		if ((information.length > 1)
				&& (user.getUsrPw().equals(information[1]))) {
			return true;
		}
		return false;
	}

	public UserDetails getUserFromToken(String token) {
		Token verifyToken = this.originTokenService.verifyToken(token);
		String[] information = verifyToken.getExtendedInformation().split("=");
		User user = this.userService.getUserById(information[0]);

		RegisterUserDetails userDetails = new RegisterUserDetails(user);
		return userDetails;
	}
}
