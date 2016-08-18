package com.sales.taxes.item;

import com.sales.taxes.enums.Origin;
import com.sales.taxes.util.AbstractBuilder.ItemBuilder;

public abstract class AbstractItem {
	
	private Origin origin;
	private String name;
	private float unitPrice;
	private float netPrice;
	private float grossPrice;
	private int qty;
	
	protected AbstractItem(){}
	
	protected AbstractItem(ItemBuilder<? extends AbstractItem> builder){
		this.origin = builder.getOrigin();
		this.name = builder.getName();
		this.qty = builder.getQty();
		this.unitPrice = builder.getUnitPrice();
		this.netPrice = builder.getNetPrice();
		this.grossPrice = builder.getGrossPrice();
	}

	public Origin getOrigin() {
		return origin;
	}

	public String getName() {
		return name;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public float getNetPrice() {
		return netPrice;
	}

	public float getGrossPrice() {
		return grossPrice;
	}

	public int getQty() {
		return qty;
	}
	
	public void addTax(float taxAmount){
		this.grossPrice += taxAmount;
	}
	
	

}
