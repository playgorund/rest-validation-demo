package com.example.demo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

@Service
public class DealService {
	
	private Logger logger = LoggerFactory.getLogger(DemoApi.class);

	
	@NewSpan("Deal-Push-Logger")
	public Deal log(Deal deal) {
		
		System.out.println(" MDC = " + MDC.getCopyOfContextMap());

		logger.info("Deal Logged...");

		
		return deal;
	}

}
