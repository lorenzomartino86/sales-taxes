package com.sales.taxes.item;

import com.sales.taxes.receipt.Checkout;
import com.sales.taxes.util.AbstractBuilder.ItemBuilder;

public class Book extends AbstractItem implements Item{

	public Book(ItemBuilder<Book> builder) {
		super(builder);
	}

	@Override
	public String toString() {
		return "Book [origin=" + getOrigin() + ", name=" + getName() + ", unitPrice=" + getUnitPrice()
				+ ", netPrice=" + getNetPrice() + ", grossPrice=" + getGrossPrice() + ", qty=" + getQty()
				+ "]";
	}

	@Override
	public Item checkout(Checkout handler) {
		return handler.checkout(this);
	}
	
	

}
