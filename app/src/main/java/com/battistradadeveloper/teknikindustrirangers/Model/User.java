package com.battistradadeveloper.teknikindustrirangers.Model;

public class User {
	private String name;
	private String address;
	private String status;
	private String company;
	private String company_address;

	public  User(){}

	public User(String name, String address, String status, String company, String company_address) {
		this.name = name;
		this.address = address;
		this.status = status;
		this.company = company;
		this.company_address = company_address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getStatus() {
		return status;
	}

	public String getCompany() {
		return company;
	}

	public String getCompany_address() {
		return company_address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
}
