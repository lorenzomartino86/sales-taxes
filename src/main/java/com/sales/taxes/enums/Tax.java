package com.sales.taxes.enums;

public enum Tax {
	EXEMPT(0.0f),
	BASIC(0.1f),
	IMPORTED(0.05f);
	
	private float taxRate;
	
	private Tax(float taxRate){
		this.taxRate = taxRate;
	}
	
	public float getTaxRate(){
		return taxRate;
	}
}
