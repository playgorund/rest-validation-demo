package com.example.demo.api;

public class Amount {

	private String currency;
	
	private float value;

	public Amount() {
		
	}
	
	public Amount(String currency, float value) {
		super();
		this.currency = currency;
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Amount [currency=" + currency + ", value=" + value + "]";
	}
	
	
}
