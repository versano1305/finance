package config.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserSecurityService implements UserDetailsService {

	private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
	private final HashMap<String, User> userMap = new HashMap<String, User>();

	public void addUser(User user) {
		userMap.put(user.getUsername(), user);
	}

	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMap.get(username);
		if (user == null) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			grantedAuthorities.add(new GrantedAuthority() {

				public String getAuthority() {
					return "ADMIN";
				}
			});

			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

			String encodePassword = bCryptPasswordEncoder.encode("123456");
			user = new User(username, encodePassword, grantedAuthorities);
			// throw new UsernameNotFoundException("user not found");
		}
		detailsChecker.check(user);
		return user;
	}
}