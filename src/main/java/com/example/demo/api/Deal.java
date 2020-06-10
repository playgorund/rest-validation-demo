package com.example.demo.api;

import javax.validation.constraints.NotBlank;

public class Deal {

	@NotBlank(message = "deal code can not be blank")
	private String code;
	
	@DealName(message = "invalid deal name")
	private String name;

	public Deal() {
		
	}
	
	public Deal(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Deal [code=" + code + ", name=" + name + "]";
	}
	
}
