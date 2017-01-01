package modules.control.supplier;

import java.util.List;

import common.persistence.BaseDao;
import modules.persistence.supplier.Supplier;
import modules.persistence.user.User;

public interface SupplierDao extends BaseDao<Supplier> {

	public List<Supplier> getSupplierByUser(User user);
}
