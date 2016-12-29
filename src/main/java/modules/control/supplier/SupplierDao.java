package modules.control.supplier;

import java.util.List;

import modules.persistence.supplier.Supplier;
import modules.persistence.user.User;

public interface SupplierDao {

	public List<Supplier> getSupplierByUser(User user);
}
