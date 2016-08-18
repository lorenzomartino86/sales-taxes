package com.sales.taxes.item;

import com.sales.taxes.receipt.ItemCheckout;
import com.sales.taxes.util.AbstractBuilder.ItemBuilder;

public class Medical extends AbstractItem implements Item{
	
	public Medical(ItemBuilder<Medical> builder){
		super(builder);
	}

	@Override
	public String toString() {
		return "Medical [getOrigin()=" + getOrigin() + ", getName()=" + getName() + ", getUnitPrice()=" + getUnitPrice()
				+ ", getNetPrice()=" + getNetPrice() + ", getGrossPrice()=" + getGrossPrice() + ", getQty()=" + getQty()
				+ "]";
	}

	@Override
	public Item checkout(ItemCheckout handler) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
