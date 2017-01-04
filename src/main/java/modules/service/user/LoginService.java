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
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import config.security.TokenHandler;
import config.security.UserSecurityService;

@Component
@Path("/login")
public class LoginService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserSecurityService userSecurityService;

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

		Authentication authentication = this.authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		User loadUserByUsername = this.userSecurityService.loadUserByUsername(username);
		TokenHandler tokenHandler = new TokenHandler("ddddd", userSecurityService);
		String token = tokenHandler.createTokenForUser(loadUserByUsername);

		return Response.status(Status.OK).entity(token).build();

	}
}
