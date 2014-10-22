package com.house.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.house.model.User;

public class RegisterUserDetails implements UserDetails {
	private static Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>() {
		{
			add(new SimpleGrantedAuthority("ROLE_USER"));
		}
	};

	private User user;

	public RegisterUserDetails(User user) {
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	public String getUsername() {
		return user.getUsrNm();
	}


	public String getPassword() {
		return user.getUsrPw();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
