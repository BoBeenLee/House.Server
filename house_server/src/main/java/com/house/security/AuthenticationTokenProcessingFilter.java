package com.house.security;

import com.house.service.TokenService;
import java.io.IOException;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

public class AuthenticationTokenProcessingFilter extends GenericFilterBean {
	@Autowired
	private TokenService tokenService;
	private AuthenticationManager authManager;

	public AuthenticationTokenProcessingFilter(AuthenticationManager authManager) {
		this.authManager = authManager;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Map<String, String[]> parms = request.getParameterMap();
		if (parms.containsKey("token")) {
			String token = ((String[]) parms.get("token"))[0];
			if (this.tokenService.validate(token)) {
				UserDetails userDetails = this.tokenService
						.getUserFromToken(token);

				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails.getUsername(), userDetails.getPassword());
				authentication.setDetails(new WebAuthenticationDetailsSource()
						.buildDetails((HttpServletRequest) request));

				SecurityContextHolder.getContext().setAuthentication(
						this.authManager.authenticate(authentication));
			}
		}
		chain.doFilter(request, response);
	}
}
