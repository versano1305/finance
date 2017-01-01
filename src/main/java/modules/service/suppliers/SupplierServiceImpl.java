package modules.service.suppliers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import modules.control.supplier.SupplierDao;
import modules.persistence.supplier.Supplier;

@Component
@Path("/supplier")
public class SupplierServiceImpl {

	@Autowired
	private SupplierDao supplierDao;

	private @Autowired MongoTemplate mongoTemplate;

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Supplier> getSupplier() {
		// TODO Auto-generated method stub
		Supplier s = new Supplier("dxgs", "ddd.v@gmail.com");

		List<String> sss = new ArrayList<String>();
		sss.add("רשימה 1");
		sss.add("רשימה 2");
		sss.add("רשימה 3");
		sss.add("רשימה 4");
		sss.add("רשימה 5");

		s.setLll(sss);
		mongoTemplate.insert(s, "supplier");

		return supplierDao.getSupplierByUser(null);
	}

}
