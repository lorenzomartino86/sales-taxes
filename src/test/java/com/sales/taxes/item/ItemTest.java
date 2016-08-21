package com.sales.taxes.item;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.sales.taxes.enums.Origin;
import com.sales.taxes.util.AbstractBuilder.ItemBuilder;

public class ItemTest {
	
	@Test
	public void createBook(){
		try {
			Item book = new ItemBuilder<Book>(Book.class, Origin.LOCAL, "test book", 2, 12.49f).build();
			Assert.assertEquals(12.49f, book.getUnitPrice(), 0.001f);
			Assert.assertEquals(2, book.getQty());
			Assert.assertEquals(24.98f, book.getNetPrice(), 0.001f);
			Assert.assertEquals(book.getNetPrice(), book.getGrossPrice(), 0.001f);			
			Assert.assertEquals("test book", book.getName());
			Assert.assertEquals(Origin.LOCAL, book.getOrigin());	
			Assert.assertEquals(Book.class, book.getClass());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void createFood(){
		try {
			Item food = new ItemBuilder<Food>(Food.class, Origin.IMPORTED, "test food", 1, 5.33f).build();
			Assert.assertEquals(5.33f, food.getUnitPrice(), 0.001f);
			Assert.assertEquals(1, food.getQty());
			Assert.assertEquals(5.33f, food.getNetPrice(), 0.001f);
			Assert.assertEquals(food.getNetPrice(), food.getGrossPrice(), 0.001f);			
			Assert.assertEquals("test food", food.getName());
			Assert.assertEquals(Origin.IMPORTED, food.getOrigin());	
			Assert.assertEquals(Food.class, food.getClass());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void createMedical(){
		try {
			Item medical = new ItemBuilder<Medical>(Medical.class, Origin.LOCAL, "test medical", 3, 2.22f).build();
			Assert.assertEquals(2.22f, medical.getUnitPrice(), 0.001f);
			Assert.assertEquals(3, medical.getQty());
			Assert.assertEquals(6.66f, medical.getNetPrice(), 0.001f);
			Assert.assertEquals(medical.getNetPrice(), medical.getGrossPrice(), 0.001f);			
			Assert.assertEquals("test medical", medical.getName());
			Assert.assertEquals(Origin.LOCAL, medical.getOrigin());	
			Assert.assertEquals(Medical.class, medical.getClass());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void createOther(){
		try {
			Item other = new ItemBuilder<Other>(Other.class, Origin.IMPORTED, "test other", 2, 10.05f).build();
			Assert.assertEquals(10.05f, other.getUnitPrice(), 0.001f);
			Assert.assertEquals(2, other.getQty());
			Assert.assertEquals(20.10f, other.getNetPrice(), 0.001f);
			Assert.assertEquals(other.getNetPrice(), other.getGrossPrice(), 0.001f);			
			Assert.assertEquals("test other", other.getName());
			Assert.assertEquals(Origin.IMPORTED, other.getOrigin());	
			Assert.assertEquals(Other.class, other.getClass());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
}
