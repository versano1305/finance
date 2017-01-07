package modules.control.user;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import common.persistence.BaseDaoImpl;
import common.persistence.BaseEntity;
import modules.persistence.user.User;

@Repository
public class UserDaoImpl<E extends BaseEntity> extends BaseDaoImpl<User> implements UserDao {
	
	@Override
	public User findByUsername(String username) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(username));
		return mongoTemplate.findOne(query, type);
	}

}
