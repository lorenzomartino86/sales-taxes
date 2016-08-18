package com.sales.taxes;

import java.lang.reflect.InvocationTargetException;

import com.sales.taxes.enums.Origin;
import com.sales.taxes.item.Book;
import com.sales.taxes.item.Item;
import com.sales.taxes.item.Medical;
import com.sales.taxes.util.AbstractBuilder.ItemBuilder;

public class TestClass {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Item book = new ItemBuilder<Book>(Book.class, Origin.IMPORTED, "Libro di prova", 1, 5).build();
		System.out.println(book);
		Item medical = new ItemBuilder<Medical>(Medical.class, Origin.LOCAL, "Medical di prova", 2, 11).build();
		System.out.println(medical);

	}

}
