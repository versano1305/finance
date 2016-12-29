package modules.persistence.supplier;

import java.io.Serializable;

public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	
	public Supplier(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
