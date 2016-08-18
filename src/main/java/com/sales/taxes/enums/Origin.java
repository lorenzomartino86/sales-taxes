package com.sales.taxes.enums;

public enum Origin {
    LOCAL("local"), IMPORTED("imported");
	
	private String literal;
	
	private Origin(String literal){
		this.literal = literal;
	}
	
	public String getLiteral(){
		return literal;
	}
	
}
