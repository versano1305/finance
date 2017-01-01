package modules.service.user;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import modules.control.user.UserDao;
import modules.persistence.user.User;

@Component
@Path("/users")
public class UserService {

	@Autowired
	private UserDao userDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User user(@QueryParam("id") Long id) {
		User user = userDao.getById(id);
		return user;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response user(User user) {
		userDao.saveOrUpdate(user);
		return Response.notModified().build();
	}

}
