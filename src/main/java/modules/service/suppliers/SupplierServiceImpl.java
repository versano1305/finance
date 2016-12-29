package modules.service.suppliers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import modules.control.supplier.SupplierDao;
import modules.persistence.supplier.Supplier;

@Component
@Path("/supplier")
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao supplierDao;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Supplier> getSupplier() {
		// TODO Auto-generated method stub
		
		return supplierDao.getSupplierByUser(null);
	}

}
