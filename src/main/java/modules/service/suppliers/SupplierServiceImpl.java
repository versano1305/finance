package modules.service.suppliers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import modules.persistence.supplier.Supplier;

@Component
@Path("/supplier")
public class SupplierServiceImpl implements SupplierService {

	@GET
	@Path("/all")
	public List<Supplier> getSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

}
