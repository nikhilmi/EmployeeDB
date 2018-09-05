package com.teamsankya.employeedb.dto;

public class EmployeeAddressBean {
	private String address;
	private String city;
	private int pincode;
	private String eid;
	
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
}
