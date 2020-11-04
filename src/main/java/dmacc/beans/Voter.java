package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Voter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String phone;
	private String politicalparty;
	@Autowired
	private Address address;
	
	public Voter( ) {
		super();
		this.politicalparty = "Democrat";
	}
	
	public Voter(String name) {
		this.name = name;
	}
	
	public Voter(String name, String phone, String party) {
		this.name = name;
		this.phone = phone;
		this.politicalparty = party;
	}
	
	public Voter(int id, String name, String phone, String party) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.politicalparty = party;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPoliticalparty() {
		return politicalparty;
	}

	public void setPoliticalparty(String politicalparty) {
		this.politicalparty = politicalparty;
	}

	@Override
	public String toString() {
		return "Voter [id=" + id + ", name=" + name + ", phone=" + phone + ", politicalparty=" + politicalparty
				+ ", address=" + address + "]";
	}
	
	
	

}
