package config.security.jwt;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import modules.persistence.user.Authority;
import modules.persistence.user.User;

public final class JwtUserFactory {

	private JwtUserFactory() {
	}

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getAuthorities()),
                user.isEnabled(),
                user.getLastPasswordResetDate()
        );
    }
	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
		if (authorities == null) {
			return null;
		}
		return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
				.collect(Collectors.toList());
	}
}
