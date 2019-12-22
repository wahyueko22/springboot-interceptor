package com.aspect.interceptor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@Column(name = "id")
	private String customerId;
	@Column(name = "name")
	private String customerName;
	@Column(name = "age")
	private int cutomerAge;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCutomerAge() {
		return cutomerAge;
	}
	public void setCutomerAge(int cutomerAge) {
		this.cutomerAge = cutomerAge;
	}
	
	
	
}
