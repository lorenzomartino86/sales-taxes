package com.sales.taxes.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.sales.taxes.enums.ItemType;
import com.sales.taxes.enums.Origin;
import com.sales.taxes.item.Book;
import com.sales.taxes.item.Food;
import com.sales.taxes.item.Item;
import com.sales.taxes.item.Medical;
import com.sales.taxes.item.Other;
import com.sales.taxes.util.AbstractBuilder.ItemBuilder;

public final class DataLoader {
	
	public static List<Item> loadHardCodedData1() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		return new ArrayList<Item> (){
			{
			add(new ItemBuilder<Book>(Book.class, Origin.LOCAL, "book", 1, 12.49f).build());
			add(new ItemBuilder<Other>(Other.class, Origin.LOCAL, "music CD", 1, 14.99f).build());
			add(new ItemBuilder<Food>(Food.class, Origin.LOCAL, "chocolate bar", 1, 0.85f).build());
			}
		};
	}

	public static List<Item> loadHardCodedData2() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		return new ArrayList<Item> (){
			{
			add(new ItemBuilder<Food>(Food.class, Origin.IMPORTED, "imported box of chocolates", 1, 10.00f).build());
			add(new ItemBuilder<Other>(Other.class, Origin.IMPORTED, "imported bottle of perfume", 1, 47.50f).build());
			}
		};
	}

	public static List<Item> loadHardCodedData3() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		return new ArrayList<Item> (){
			{
			add(new ItemBuilder<Other>(Other.class, Origin.IMPORTED, "imported bottle of perfume", 1, 27.99f).build());
			add(new ItemBuilder<Other>(Other.class, Origin.LOCAL, "bottle of perfume", 1, 18.99f).build());
			add(new ItemBuilder<Medical>(Medical.class, Origin.LOCAL, "packet of headache pills", 1, 9.75f).build());
			add(new ItemBuilder<Food>(Food.class, Origin.IMPORTED, "imported box of chocolates", 1, 11.25f).build());
			}
		};
	}
	
	
	public static Item loadFromCommandLine() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		String productName = loadProductName();
		int qty = loadQuantity();
		float unitPrice = loadUnitPrice();
		Origin productOrigin = loadOriginOfProduct();
		ItemType itemType = loadTypeOfProduct();
		
		Item item = null;
		switch (itemType){
			case FOOD:
				item = new ItemBuilder<Food>(Food.class, productOrigin, productName, qty, unitPrice).build();
				break;
			case MEDICAL:
				item = new ItemBuilder<Medical>(Medical.class, productOrigin, productName, qty, unitPrice).build();
				break;
			case BOOK:
				item = new ItemBuilder<Book>(Book.class, productOrigin, productName, qty, unitPrice).build();
				break;
			case OTHER:
				item = new ItemBuilder<Other>(Other.class, productOrigin, productName, qty, unitPrice).build();
				break;
		}
		return item;
	}
	
	
	@SuppressWarnings("resource")
	public static String getInputString(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	@SuppressWarnings("resource")
	public static float getInputFloat(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextFloat();	
	}
	
	@SuppressWarnings("resource")
	public static int getInputInt(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();	
	}	
	
	private static String loadProductName(){
		String productName = "";
		boolean inputCLcheck = false;
		do{
			try{
				System.out.print("Enter product name:");
				productName = getInputString();		
				inputCLcheck = true;
			} catch (InputMismatchException ime){
	            System.out.println("Incorrect input, please type a valid string.");
	        }
		} while(!inputCLcheck);	
		return productName;
	}
	
	private static int loadQuantity(){
		int qty = 0;
		boolean inputCLcheck = false;
		do{
			try{
				System.out.print("Enter quantity:");
				qty = getInputInt();
				inputCLcheck = true;
			} catch (InputMismatchException ime){
	            System.out.println("Incorrect input, please type a valid integer.");
	        }
		} while(!inputCLcheck);
		return qty;
	}
	
	private static float loadUnitPrice(){
		float unitPrice = 0.0f;
		boolean inputCLcheck = false;
		do{
			try{
				System.out.print("Enter unit price:");
				unitPrice = getInputFloat();
				inputCLcheck = true;
			} catch (InputMismatchException ime){
	            System.out.println("Incorrect input, please type a valid float number.");
	        }	

		} while(!inputCLcheck);
		return unitPrice;
	}
	
	private static Origin loadOriginOfProduct(){
		Origin origin = Origin.LOCAL;
		boolean inputCLcheck = false;
		do{
			try{
				System.out.print("Enter origin of product (a - local, b - imported): ");
				String originInput = getInputString();
				inputCLcheck = true;				
				if (originInput.equals("a")){
					origin = Origin.LOCAL;
				} else if (originInput.equals("b")){
					origin = Origin.IMPORTED;
				} else {
					inputCLcheck = false;
					System.out.println("Incorrect input, please type a valid letter (a or b).");
				}
				
			} catch (InputMismatchException ime){
	            System.out.println("Incorrect input, please type a valid letter (a or b).");
			}		
		} while(!inputCLcheck);
		return origin;
	}	
	
	private static ItemType loadTypeOfProduct(){
		ItemType type = ItemType.OTHER;
		boolean inputCLcheck = false;
		do{
			try{
				System.out.print("Enter type of product. "
						+ "Select between \n"
						+ "a - BOOK \n"
						+ "b - MEDICAL \n"
						+ "c - FOOD \n"
						+ "d - OTHER \n"
						+ "Selection:");
				String typeInput = getInputString();
				inputCLcheck = true;
				if (typeInput.equals("a")){
					type = ItemType.BOOK;
				} else if (typeInput.equals("b")){
					type = ItemType.MEDICAL;
				} else if (typeInput.equals("c")){
					type = ItemType.FOOD;
				} else if (typeInput.equals("d")){
					type = ItemType.OTHER;
				} else {
					inputCLcheck = false;
					System.out.println("Incorrect input, please type a valid letter (a or b or c or d).");
				}
				
			} catch (InputMismatchException ime){
				System.out.println("Incorrect input, please type a valid letter (a or b or c or d).");
			}		
		} while(!inputCLcheck);
		return type;
	}	
	
}
