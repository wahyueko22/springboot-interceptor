package com.aspect.interceptor.dao;

import java.util.List;

import com.aspect.interceptor.model.Customer;

public interface CustomCustomerDao {
	List<Customer> getCustomerByCriteria();
	List<Customer> getCustomerByNative();
}
