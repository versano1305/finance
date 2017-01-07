package modules.service.user;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import config.security.jwt.JwtTokenUtil;
import modules.control.user.UserDao;

@Component
@Path("/login")
public class LoginService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private UserDao userDao ;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

	@POST
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@HeaderParam("username") String username, @HeaderParam("password") String password) {

		if (username == null) {
			return Response.status(Status.PRECONDITION_FAILED.getStatusCode()).entity("Username value is missing!!!")
					.build();
		}

		if (password == null) {
			return Response.status(Status.PRECONDITION_FAILED.getStatusCode()).entity("Password value is missing!!!")
					.build();
		}
//
//		String encode = passwordEncoder.encode(password);
//		User user = new User(username, "dddd", "sss","ssss",encode,true,new Date());
//		userDao.save(user);
		
		Authentication authentication = this.authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));


		SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);

        return Response.ok(token).build();
        
	}
}
