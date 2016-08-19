package com.sales.taxes;

import java.util.List;

import com.sales.taxes.item.Item;
import com.sales.taxes.receipt.Checkout;
import com.sales.taxes.receipt.CheckoutImpl;
import com.sales.taxes.receipt.Receipt;


public class Controller {
	public void generateAndPrintReceipt(List<Item> itemList){
		System.out.println("Input:");
		itemList.forEach(r -> {
			System.out.println(r);
		});

		Receipt receipt = generateOverallReceipt(itemList);

		System.out.println(receipt);
	}
	
	public Receipt generateOverallReceipt(List<Item> itemList){
		Checkout handler = new CheckoutImpl();
		itemList.forEach( item -> item.checkout(handler));	
		return handler.getReceipt();
	}
}
