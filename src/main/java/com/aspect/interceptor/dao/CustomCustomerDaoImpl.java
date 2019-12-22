package com.aspect.interceptor.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.aspect.interceptor.model.Customer;

public class CustomCustomerDaoImpl implements CustomCustomerDao{
	@PersistenceContext	
	private EntityManager em;
	
	public List<Customer> getCustomerByCriteria(){
		 TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
		 //em.createQ
		 List<Customer> results = query.getResultList();
		return results;
	}

	@Override
	public List<Customer> getCustomerByNative() {
		// TODO Auto-generated method stub
		 String query = "SELECT c FROM Customer c";
	        Query nativeQuery = em.createNativeQuery(query);
	        nativeQuery.setParameter("name", "jIko");
	        //Paginering
	        nativeQuery.setFirstResult(0);
	        nativeQuery.setMaxResults(10);
	        final List<Object[]> resultList = nativeQuery.getResultList();
	        List<Customer> lsCustomer = new ArrayList<Customer>();
		    for (Object[] arrObj : resultList) {
				Customer cust = new Customer();
				cust.setCustomerId(arrObj[0].toString());
				cust.setCustomerName(arrObj[1].toString());
			}
	        
	        return lsCustomer;
	}
	
}
