package com.SupplierMicroservices;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Supplier")
public class Supplier {
	@Id
	private String id;
	private String name;
	private String email;
	private long phoneNumber;
	private String drugName;
	private long drugPrice;
	public Supplier() {
		super();
	}
	public Supplier(String id, String name, String email, long phoneNumber, String drugName, long drugPrice) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.drugName = drugName;
		this.drugPrice = drugPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public long getDrugPrice() {
		return drugPrice;
	}
	public void setDrugPrice(long drugPrice) {
		this.drugPrice = drugPrice;
	}
	
}
