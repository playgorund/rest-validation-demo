package com.example.demo.api;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.Span;
import brave.Tracer;
import brave.propagation.ExtraFieldPropagation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/deal")
public class DemoApi {
	
	private Logger logger = LoggerFactory.getLogger(DemoApi.class);

	@Autowired
	private Tracer tracer;
	
	@Autowired
	private DealService dealService;
	
	
	@GetMapping
	public String hello() {
		return "hello";
	}
	
	@PostMapping
	@NewSpan("Deal-Push-Span")
	public Deal deal(@RequestBody @Valid Deal deal) {
			
		MDC.put("dealCode", deal.getCode());
		//tracer.currentSpan().tag("DealCode", deal.getCode().toString());
		//ExtraFieldPropagation.set(tracer.currentSpan().context(), "dealCode", deal.getCode());
		
		System.out.println(" MDC = " + MDC.getCopyOfContextMap());

		logger.info("Deal pushed...");

		deal = dealService.log(deal);
		
		return deal;
	}
	
}
