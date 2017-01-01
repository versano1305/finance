package modules.control.user;

import org.springframework.stereotype.Repository;

import common.persistence.BaseDaoImpl;
import common.persistence.BaseEntity;
import modules.persistence.user.User;

@Repository
public class UserDaoImpl<E extends BaseEntity> extends BaseDaoImpl<User> implements UserDao {

}
