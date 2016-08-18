package com.sales.taxes;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.sales.taxes.enums.Origin;
import com.sales.taxes.item.Book;
import com.sales.taxes.item.Food;
import com.sales.taxes.item.Item;
import com.sales.taxes.item.Medical;
import com.sales.taxes.item.Other;
import com.sales.taxes.util.AbstractBuilder.ItemBuilder;

public class TestClass {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Item book = new ItemBuilder<Book>(Book.class, Origin.IMPORTED, "Libro di prova", 1, 5).build();
		System.out.println(book);
		Item medical = new ItemBuilder<Medical>(Medical.class, Origin.LOCAL, "Medical di prova", 2, 11).build();
		System.out.println(medical);
		
		List<Item> itemList = new ArrayList<Item> ();
		itemList.add(new ItemBuilder<Book>(Book.class, Origin.LOCAL, "book", 1, 12.49f).build());
		itemList.add(new ItemBuilder<Other>(Other.class, Origin.LOCAL, "music CD", 1, 14.99f).build());
		itemList.add(new ItemBuilder<Food>(Food.class, Origin.LOCAL, "chocolate bar", 1, 0.85f).build());
		
		SalesController controller = new SalesController();
		controller.generateAndPrintReceipt(itemList);
		
		itemList = new ArrayList<Item> ();
		itemList.add(new ItemBuilder<Food>(Food.class, Origin.IMPORTED, "imported box of chocolates", 1, 10.00f).build());
		itemList.add(new ItemBuilder<Other>(Other.class, Origin.IMPORTED, "imported bottle of perfume", 1, 47.50f).build());
		controller.generateAndPrintReceipt(itemList);
		
		
	}

}
