package com.insuranceapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AppUserMapper {
	// Convert the UserDetails to ApppUser
	public AppUser convertToAppUser(UserDetails userDetails) {
		String username = userDetails.getUsername();
		String password = userDetails.getPassword();
		AppUser appUser = new AppUser();
		appUser.setUsername(username);
		appUser.setPassword(password);

		return appUser;
	}

	// From DataBase to FrontEnd
	// Convert the ApppUser to UserDetails
	public UserDetails convertToUserDetails(AppUser appUser) {
		String username = appUser.getUsername();
		String password = appUser.getPassword();
		List<GrantedAuthority> authorities = new ArrayList<>();

		List<String> roles = Arrays.asList("user", "admin");
		for (String role : roles) {
			// Create a Simple granted authority
			SimpleGrantedAuthority simpAuthority = new SimpleGrantedAuthority(role);
			// add this to the list of granted authority
			authorities.add(simpAuthority);
		}
		// create a UserDetails object
		UserDetails details = new User(username, password, authorities);
		return details;
	}
}
