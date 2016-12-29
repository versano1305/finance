package modules.service.suppliers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import modules.persistence.supplier.Supplier;

@Component
@Path("/supplier")
public class SupplierServiceImpl implements SupplierService {

	private List<Supplier> suppliersList;
	
	public SupplierServiceImpl() {

		suppliersList = new ArrayList<Supplier>();
		suppliersList.add(new Supplier("sdsdg", "sdgsg"));
		suppliersList.add(new Supplier("gsdgs", "sdgsg"));
		suppliersList.add(new Supplier("sdgsdgsd", "sdgsg"));

	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Supplier> getSupplier() {
		// TODO Auto-generated method stub
		
		return suppliersList;
	}

}
