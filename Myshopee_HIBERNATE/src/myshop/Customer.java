package myshop;

import java.util.Set;

public class Customer {
	private String customer_code;
	private String customer_name;
	private String phone_number;
	private String address;
	private Set<Item> itemlst;
	public Set<Item> getItemlst() {
		return itemlst;
	}
	public void setItemlst(Set<Item> itemlst) {
		this.itemlst = itemlst;
	}
	public String getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
