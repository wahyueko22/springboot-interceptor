package com.aspect.interceptor;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.aspect.interceptor.dao.CustomCustomerDao;
import com.aspect.interceptor.dao.CustomCustomerDaoImpl;
import com.aspect.interceptor.dao.CustomerDao;
import com.aspect.interceptor.model.Customer;
import com.aspect.interceptor.services.BeanUtil;
import com.aspect.interceptor.services.EmailServiceInter;


@SpringBootApplication
@EnableScheduling  //for scheduler service
public class InterceptorApplication {

	public static void main(String[] args) {
		 ApplicationContext app =  SpringApplication.run(InterceptorApplication.class, args);
	}

}
