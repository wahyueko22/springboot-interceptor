package com.aspect.interceptor.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerService {
	//@Scheduled(fixedRate = 1000)
    public void create() {
		System.out.println("jalan SchedulerService");
	}
}
