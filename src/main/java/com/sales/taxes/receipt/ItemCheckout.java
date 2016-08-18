package com.sales.taxes.receipt;

import com.sales.taxes.item.Book;
import com.sales.taxes.item.Food;
import com.sales.taxes.item.Item;
import com.sales.taxes.item.Medical;
import com.sales.taxes.item.Other;

public interface ItemCheckout {
	
	public Item checkout(Book book);
	public Item checkout(Food food);
	public Item checkout(Medical medical);
	public Item checkout(Other other);
	
	public float applyBasicTax(float price);
	public float applyImportedTax(float price);	

}
