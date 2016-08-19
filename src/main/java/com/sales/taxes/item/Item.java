package com.sales.taxes.item;

import com.sales.taxes.enums.Origin;
import com.sales.taxes.receipt.Checkout;

public interface Item {

	public Origin getOrigin();

	public String getName();

	public float getUnitPrice();

	public float getNetPrice();

	public float getGrossPrice();

	public int getQty();
	
	public void addTax(float taxAmount);
	
	public Item checkout(Checkout handler);
	
}
