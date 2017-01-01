package modules.persistence.supplier;

import java.util.List;

import common.persistence.BaseEntity;

public class Supplier extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private List<String> lll;
	
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

	public List<String> getLll() {
		return lll;
	}

	public void setLll(List<String> lll) {
		this.lll = lll;
	}
		
}
