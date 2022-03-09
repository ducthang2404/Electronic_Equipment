package com.electronic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.electronic.dao.StaffDAO;
import com.electronic.entity.Staff;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private StaffDAO staffDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Staff appUser = this.staffDao.findByUsername(userName);

		if (appUser == null) {
			System.out.println("User not found! " + userName);
			throw new UsernameNotFoundException("User " + userName + " was not found in the database");
		}

		System.out.println("Found User: " + appUser);

		// [ROLE_USER, ROLE_ADMIN,..]
		String roleNames = appUser.getRolename();

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roleNames != null) {
			// ROLE_USER, ROLE_ADMIN,..
			GrantedAuthority authority = new SimpleGrantedAuthority(roleNames);
			grantList.add(authority);
		}

		UserDetails userDetails = (UserDetails) new User(appUser.getUsername(), //
				appUser.getPassword(), grantList);

		return userDetails;
	}

}
