package com.sales.taxes;

import java.lang.reflect.InvocationTargetException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.Options;

import com.sales.taxes.item.Item;
import com.sales.taxes.util.DataLoader;


public class App {

	private static HelpFormatter formatter;
		private static Options options;
		private static Controller controller;
		
		public static void main(String[] args) {		
			options = new Options();
			options.addOption("h", "help", false, "show help");
			options.addOption("a", "hardcoded", false, "test on hardcoded data");
			options.addOption("b", "input", false, "test on new data [required user input]");

			formatter = new HelpFormatter();

			CommandLineParser parser = new DefaultParser();
			try {
				CommandLine cmd = parser.parse(options, args);
				if (cmd.hasOption('h')) {
					usage();
				} else {
					if (cmd.hasOption('a')) {
						testHardCodedData();
					} else if (cmd.hasOption('b')){
						testOnCommandLineData();
					}
				}
			} catch (MissingArgumentException e) {
				System.err.println(e.getMessage());
				usage();
			} catch (InvalidParameterException e) {
				System.err.println(e.getMessage());
				usage();
			} catch (Exception e) {
				System.err.println(e.getStackTrace().toString());
			}
		}
		
		private static void usage() {
			formatter.printHelp("java -jar SalesTaxes-1.0.0.jar ", "", options, "", true);
		}
		
		
		private static void testHardCodedData(){
			controller = new Controller();		
			try {
				controller.generateAndPrintReceipt(DataLoader.loadHardCodedData1());
				System.out.println("\n");
				controller.generateAndPrintReceipt(DataLoader.loadHardCodedData2());
				System.out.println("\n");
				controller.generateAndPrintReceipt(DataLoader.loadHardCodedData3());
			} catch (InstantiationException | IllegalAccessException | InvocationTargetException
					| NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		
		}
		
		private static void testOnCommandLineData(){		
			controller = new Controller();	
			List<Item> itemList = new ArrayList<Item> ();
			
			boolean stopLoop = false;
			do {				
				try {
					itemList.add(DataLoader.loadFromCommandLine());
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
				
				try{
					System.out.print("Do you want to insert new item (Y/N)? ");
					String answer = DataLoader.getInputString();	
					if (answer.equals("N"))
						stopLoop = true;
				} catch (InputMismatchException ime){
			           System.out.println("Incorrect input, please type Y or N");
			    }
				
			} while (!stopLoop);
			
			controller.generateAndPrintReceipt(itemList);		
		
		}
	

}
