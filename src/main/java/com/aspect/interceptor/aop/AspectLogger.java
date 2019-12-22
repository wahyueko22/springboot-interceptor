package com.aspect.interceptor.aop;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class AspectLogger {
	private static Logger logger = LoggerFactory.getLogger(AspectLogger.class);

	
	  @Around("execution(* com.aspect.interceptor..*.*(..))") 
	  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

			logger.info("{} : Around before is running! : {}" ,joinPoint.getSignature().getName(), new Date());
			
			Object result = joinPoint.proceed(); // continue on the intercepted method
			
			logger.info("Around after is running! : {}", new Date());
			logger.info("******");
			return result;
	 }
	 

}