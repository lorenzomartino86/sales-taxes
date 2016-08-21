package com.sales.taxes.receipt;

import static com.sales.taxes.util.Literal.df;

import java.util.ArrayList;
import java.util.List;

import com.sales.taxes.item.Item;

public class Receipt {
	
	private List<Item> itemList = new ArrayList<Item> ();
	private float totalPrice;
	private float totalTaxes;
	
	public void addItem(Item item){
		this.itemList.add(item);
		this.totalPrice += item.getGrossPrice();
		this.totalTaxes += (item.getGrossPrice() - item.getNetPrice());
	}
	
	public float getTotalPrice(){
		return totalPrice;
	}
	
	public float getTotalTaxes(){
		return totalTaxes;
	}
	
	@Override
	public String toString(){
		StringBuilder receipt = new StringBuilder();
		receipt.append("*******************************************\n")
			   .append("************ RECEIPT **********************\n")
			   .append("*******************************************\n");
		itemList.forEach( item -> {
			receipt.append(" ")
				   .append(item.getQty())
			       .append(" ")
			       .append(item.getName())
			       .append(": ")
			       .append(df.format(item.getGrossPrice()))
			       .append("\n");			
		});	
		return receipt.append("*******************************************")
			   .append("\n")
			   .append("   Sales Taxes: ")
		       .append(df.format(totalTaxes))
		       .append("\n")
		       .append("   Total: ")
		       .append(df.format(totalPrice))
		       .append("\n")
		       .append("*******************************************")
		       .toString();	
	}
	
	

}
