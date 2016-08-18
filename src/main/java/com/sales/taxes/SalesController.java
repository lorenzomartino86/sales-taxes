package com.sales.taxes;

import java.util.List;

import com.sales.taxes.item.Item;
import com.sales.taxes.receipt.ItemCheckout;
import com.sales.taxes.receipt.ItemCheckoutHandler;
import com.sales.taxes.receipt.Receipt;


public class SalesController {
	public void generateAndPrintReceipt(List<Item> itemList){
		System.out.println("Input:");
		itemList.forEach(r -> {
			System.out.println(r);
		});

		Receipt receipt = generateOverallReceipt(itemList);

		System.out.println(receipt);
	}
	
	public Receipt generateOverallReceipt(List<Item> itemList){
		ItemCheckout handler = new ItemCheckoutHandler();
		itemList.forEach( item -> item.checkout(handler));	
		return handler.getReceipt();
	}
}
