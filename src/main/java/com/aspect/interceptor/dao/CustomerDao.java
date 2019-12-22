package com.aspect.interceptor.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspect.interceptor.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer,String>, CustomCustomerDao{
	
}
