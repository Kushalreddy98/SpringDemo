package com.insuranceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insuranceapp.model.AppUser;
import com.insuranceapp.model.AppUserMapper;
import com.insuranceapp.repository.IAppUserRepository;

@Service
@Transactional
public class AppUserServiceImpl implements UserDetailsManager{

	@Autowired
	private IAppUserRepository appUserRepository;
	
	@Autowired
	private AppUserMapper appUsermapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser= appUserRepository.findByUsername(username);
		if(appUser==null)
			throw new UsernameNotFoundException("username doesnot exist");
		UserDetails details=appUsermapper.convertToUserDetails(appUser);
		return details;
	}

	@Override
	public void createUser(UserDetails user) {
		AppUser appUser= appUsermapper.convertToAppUser(user);
		appUserRepository.addUser(appUser);
		
	}

	@Override
	public void updateUser(UserDetails user) {
		AppUser appUser= appUsermapper.convertToAppUser(user);
		appUserRepository.updateUser(appUser);
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
