package com.sales.taxes.receipt;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.sales.taxes.enums.Origin;
import com.sales.taxes.item.Book;
import com.sales.taxes.item.Item;
import com.sales.taxes.item.Medical;
import com.sales.taxes.item.Other;
import com.sales.taxes.util.AbstractBuilder.ItemBuilder;

public class GlobalReceiptTest {

	private Checkout handler = new CheckoutImpl();

	@Test
	public void overallReceiptAmounts() {
		try {
			Book book = new ItemBuilder<Book>(Book.class, Origin.LOCAL, "test book", 2, 12.49f).build();
			Item item1 = handler.checkout(book);
			float taxItem1 = item1.getGrossPrice() - item1.getNetPrice();
			
			Medical medical = new ItemBuilder<Medical>(Medical.class, Origin.IMPORTED, "test medical", 3, 2.22f)
					.build();
			Item item2 = handler.checkout(medical);
			float taxItem2 = item2.getGrossPrice() - item2.getNetPrice();
			
			Other other = new ItemBuilder<Other>(Other.class, Origin.IMPORTED, "test other", 2, 5.5f).build();
			Item item3 = handler.checkout(other);
			float taxItem3 = item3.getGrossPrice() - item3.getNetPrice();
			
			/**
			 * Calculating total taxes and total price separately
			 */
			float totalTaxes = taxItem1 + taxItem2 + taxItem3;
			float totalPrice = item1.getGrossPrice() + item2.getGrossPrice() + item3.getGrossPrice();
			
			/** 
			 * Getting overall receipt
			 */
			Receipt receipt = handler.getReceipt();			
			
			/**
			 * Check evaluation of total taxes and total price on the overall receipt
			 */
			Assert.assertEquals(totalTaxes, receipt.getTotalTaxes(), 0.001f);
			Assert.assertEquals(totalPrice, receipt.getTotalPrice(), 0.001f);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
