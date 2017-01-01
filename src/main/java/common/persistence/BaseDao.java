package common.persistence;

public interface BaseDao<E extends BaseEntity> {

	public void save(E entity);

	public void saveOrUpdate(E entity);

	public void delete(E entity);

	public E getById(Long id);
}
