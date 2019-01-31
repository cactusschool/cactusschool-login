package com.ashish.jwt.token.services;

import java.util.ArrayList;
import java.util.List;

import net.bytebuddy.asm.Advice.This;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.ashish.jwt.token.db.model.User;
import com.ashish.jwt.token.db.repositories.AppUserRepository;

@Component
public class AppUserDetailsServices implements UserDetailsService {

	@Autowired
	private AppUserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		try {
			User user = userRepo.findByUserName(username);
			
			if(user == null) {
				throw new UsernameNotFoundException(String.format("The username %username doesn't exist.", username));
			}
			
			boolean isUserActive = (user.getEndDate() == null) ? true : false;
			
			/*List<GrantedAuthority> authorities = new ArrayList<>();
			user.getUserRoles().forEach(userrole -> {
				authorities.add(new SimpleGrantedAuthority(userrole.getRoleMaster().getRoleName()));
			});*/
			
			userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), 
					isUserActive, true, true, true, getGrantedAuthorities(user));
			
			/*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			for(int i = 0; i < 10; i++) {
				System.out.println(encoder.encode("ashish"));
			}*/
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userDetails;
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        user.getUserRoles().forEach(userrole -> {
        	
        	userrole.getRoleMaster().getRoleAccesses().forEach( roleaccess -> {
        		authorities.add(new SimpleGrantedAuthority("ROLE_" + userrole.getRoleMaster().getRoleName() + "_" + roleaccess.getRoleAccessPermission()));
        	});
		});
        
        return authorities;
}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for(int i = 0; i < 10; i++) {
			System.out.println(encoder.encode("pranab"));
		}
	}

}
