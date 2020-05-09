package com.example.auth.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.auth.entity.UserEntity;
import com.example.auth.entity.UserRepository;

@Service // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> currentUserOpt = repository.findByUsername(username);
		if (currentUserOpt.isPresent()) {
			UserEntity currentUser = currentUserOpt.get();
			UserDetails user = new org.springframework.security.core.userdetails.User(username,
					currentUser.getPassword(), true, true, true, true,
					AuthorityUtils.createAuthorityList(currentUser.getRole()));
			return user;
		}
		throw new UsernameNotFoundException("No User found!");

	}

}