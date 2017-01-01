package common.persistence;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDaoImpl<E extends BaseEntity> implements BaseDao<E> {

	protected @Autowired MongoTemplate mongoTemplate;
	protected Class<E> type;

	@SuppressWarnings("unchecked")
	protected BaseDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<E>) pt.getActualTypeArguments()[0];
	}

	public void save(E entity) {
		mongoTemplate.insert(entity);
	}

	public void saveOrUpdate(E entity) {
		mongoTemplate.save(entity);
	}

	public void delete(E entity) {
		mongoTemplate.remove(entity);
	}

	public E getById(Long id) {

		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, type);
	}

}
