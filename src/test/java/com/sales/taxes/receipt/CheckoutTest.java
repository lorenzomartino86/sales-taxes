package com.sales.taxes.receipt;

import static com.sales.taxes.util.Literal.BASE_OF_ROUND;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.sales.taxes.enums.Origin;
import com.sales.taxes.enums.Tax;
import com.sales.taxes.item.Book;
import com.sales.taxes.item.Item;
import com.sales.taxes.item.Medical;
import com.sales.taxes.item.Other;
import com.sales.taxes.util.AbstractBuilder.ItemBuilder;

public class CheckoutTest {

	private Checkout handler = new CheckoutImpl();

	@Test
	public void checkoutLocalBook() {
		try {
			Book book = new ItemBuilder<Book>(Book.class, Origin.LOCAL, "test book", 2, 12.49f).build();
			Item item = handler.checkout(book);
			Assert.assertEquals(12.49f, item.getUnitPrice(), 0.001f);
			Assert.assertEquals(2, item.getQty());
			Assert.assertEquals(24.98f, item.getNetPrice(), 0.001f);
			Assert.assertEquals(item.getNetPrice(), item.getGrossPrice(), 0.001f);
			Assert.assertEquals("test book", item.getName());
			Assert.assertEquals(Origin.LOCAL, item.getOrigin());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void checkoutImportedMedical() {
		try {
			Medical medical = new ItemBuilder<Medical>(Medical.class, Origin.IMPORTED, "test medical", 3, 2.22f)
					.build();
			Item item = handler.checkout(medical);
			Assert.assertEquals(2.22f, item.getUnitPrice(), 0.001f);
			Assert.assertEquals(3, item.getQty());
			Assert.assertEquals(6.66f, item.getNetPrice(), 0.001f);
			Assert.assertEquals(item.getNetPrice()
					+ (float) Math.ceil((item.getNetPrice() * Tax.IMPORTED.getTaxRate()) / BASE_OF_ROUND)
							* BASE_OF_ROUND,
					item.getGrossPrice(), 0.001f);
			Assert.assertEquals("test medical", item.getName());
			Assert.assertEquals(Origin.IMPORTED, item.getOrigin());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void checkoutImportedOther() {
		try {
			Other other = new ItemBuilder<Other>(Other.class, Origin.IMPORTED, "test other", 2, 5.5f).build();
			Item item = handler.checkout(other);
			Assert.assertEquals(5.5f, item.getUnitPrice(), 0.001f);
			Assert.assertEquals(2, item.getQty());
			Assert.assertEquals(11f, item.getNetPrice(), 0.001f);
			Assert.assertEquals(item.getNetPrice()
					+ ((float) Math.ceil((item.getNetPrice() * Tax.BASIC.getTaxRate()) / BASE_OF_ROUND) * BASE_OF_ROUND)
					+ ((float) Math.ceil((item.getNetPrice() * Tax.IMPORTED.getTaxRate()) / BASE_OF_ROUND)
							* BASE_OF_ROUND),
					item.getGrossPrice(), 0.001f);
			Assert.assertEquals("test other", item.getName());
			Assert.assertEquals(Origin.IMPORTED, item.getOrigin());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void checkoutLocalOther() {
		try {
			Other other = new ItemBuilder<Other>(Other.class, Origin.LOCAL, "test other", 2, 5.5f).build();
			Item item = handler.checkout(other);
			Assert.assertEquals(5.5f, item.getUnitPrice(), 0.001f);
			Assert.assertEquals(2, item.getQty());
			Assert.assertEquals(11f, item.getNetPrice(), 0.001f);
			Assert.assertEquals(item.getNetPrice()
					+ ((float) Math.ceil((item.getNetPrice() * Tax.BASIC.getTaxRate()) / BASE_OF_ROUND) * BASE_OF_ROUND),
					item.getGrossPrice(), 0.001f);
			Assert.assertEquals("test other", item.getName());
			Assert.assertEquals(Origin.LOCAL, item.getOrigin());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
