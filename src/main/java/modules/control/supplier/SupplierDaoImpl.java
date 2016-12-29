package modules.control.supplier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import modules.persistence.supplier.Supplier;
import modules.persistence.user.User;

@Repository
public class SupplierDaoImpl implements SupplierDao {

	private List<Supplier> suppliersList;
	
	public SupplierDaoImpl() {
		// TODO Auto-generated constructor stub
		suppliersList = new ArrayList<Supplier>();
		suppliersList.add(new Supplier("sdsdg", "sdgsg"));
		suppliersList.add(new Supplier("gsdgs", "sdgsg"));
		suppliersList.add(new Supplier("sdgsdgsd", "sdgsg"));
	}
	
	public List<Supplier> getSupplierByUser(User user) {
		// TODO Auto-generated method stub
		return suppliersList;
	}

}
