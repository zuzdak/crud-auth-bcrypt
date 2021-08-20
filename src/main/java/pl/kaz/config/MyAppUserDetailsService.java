package pl.kaz.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.kaz.domain.Author;
import pl.kaz.service.AuthorService;

@Service
public class MyAppUserDetailsService implements UserDetailsService {
  
	@Autowired
	private AuthorService authorService;
  
	@Override
	public UserDetails loadUserByUsername(String userName) 
			throws UsernameNotFoundException {
		Author activeUser = authorService.getActiveAuthor(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(activeUser.getRole());
		UserDetails userDetails = (UserDetails)new User(activeUser.getUserName(),
				activeUser.getPassword(), Arrays.asList(authority));
		return userDetails;
	}

}
