package com.sales.taxes.receipt;

import static com.sales.taxes.util.Literal.BASE_OF_ROUND;

import com.sales.taxes.enums.Origin;
import com.sales.taxes.enums.Tax;
import com.sales.taxes.item.Book;
import com.sales.taxes.item.Food;
import com.sales.taxes.item.Item;
import com.sales.taxes.item.Medical;
import com.sales.taxes.item.Other;

public class ItemCheckoutHandler implements ItemCheckout{

	@Override
	public Item checkout(Book book) {
		if (book.getOrigin().equals(Origin.IMPORTED))
			book.addTax(applyImportedTax(book.getNetPrice()));
		return book;
	}

	@Override
	public Item checkout(Food food) {
		if(food.getOrigin().equals(Origin.IMPORTED))
			food.addTax(applyImportedTax(food.getNetPrice()));
		return food;
	}

	@Override
	public Item checkout(Medical medical) {
		if (medical.getOrigin().equals(Origin.IMPORTED))
			medical.addTax(applyImportedTax(medical.getNetPrice()));
		return medical;
	}

	@Override
	public Item checkout(Other other) {
		if (other.getOrigin().equals(Origin.IMPORTED))
			other.addTax(other.getNetPrice());
		return other;
	}

	@Override
	public float applyBasicTax(float price) {
		return roundTax(price * Tax.BASIC.getTaxRate());
	}

	@Override
	public float applyImportedTax(float price) {
		return roundTax(price * Tax.IMPORTED.getTaxRate());
	}
	
	private float roundTax(float taxAmount){
		return (float) Math.ceil(taxAmount / BASE_OF_ROUND) * BASE_OF_ROUND;
	}

}
