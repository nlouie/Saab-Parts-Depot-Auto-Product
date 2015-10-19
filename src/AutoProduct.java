/**************************************************
 * File: AutoProduct.java
 * @author Nick Louie (nickmlouie@gmail.com) 
 * Date: 5/29/2014
 * Description: This program query fields necessary for the addition of a
 * product and prints the information necessary. Simply copy and paste. 
 *
 */

import java.util.*;

public class AutoProduct {

	/*
	 * Class Variables
	 */

	public static String name; // name of product
	public static String[] models; // array of models it fits
	public static String productNum; // product number
	public static String[] years; // array of years it fits
	public static double cost; // cost of the product
	public static final double MARK_UP = .35; // mark up value
	public static String meta; // extra meta info
	public static String extraInfo; // extra info at top
	public static String extraInfo2; // extra info at bottom
	public static boolean specialItem = false; // special item
	public static boolean clearanceItem = false; // clearance item
	public static boolean usedItem = false; // used item
	public static boolean rebuiltItem = false; // rebuilt item

	/*
	 * Main Method
	 */

	public static void main(String args[]) {

		System.out
				.println("Welcome to Auto Product for Saab Parts Depot Magento!\n");
		parse(); // ask for the values
		print(); // print the good stuff

		// ask if want to run again.
		System.out.println("\nPress enter to restart");
		Scanner query = new Scanner(System.in);
		query.nextLine();
		main(args);

	}

	/*
	 * Asks for all the fields necessary
	 */
	public static void parse() {

		// new scanner
		Scanner console = new Scanner(System.in);

		// Ask for the name of the product
		System.out.println("Name of product? eg. \"Gas Cap\" : ");
		name = console.nextLine();
		System.out.println();

		// Ask for the Product number
		System.out.println("Product number? : ");
		productNum = console.next();
		console.nextLine();
		System.out.println();

		// Ask if clearance Item
		while (true) {
			System.out
					.println("Special Item? Clearance = c/1. Used = u/2. Rebuilt = r/3 Skip = n/0");
			String ci = console.next();
			// if clearance Item
			if (ci.equalsIgnoreCase("c") || ci.equals("1")) {
				specialItem = true;
				clearanceItem = true;
				break;
				// if used item
			} else if (ci.equalsIgnoreCase("u") || ci.equals("2")) {
				specialItem = true;
				usedItem = true;
				break;
				// if rebuilt item
			} else if (ci.equalsIgnoreCase("r") || ci.equals("3")) {
				specialItem = true;
				rebuiltItem = true;
				break;
				// skip...
			} else if (ci.equalsIgnoreCase("n") || ci.equals("0")) {
				specialItem = false;
				clearanceItem = false;
				break;
				// incorrect input, re enter console
			} else {
				System.out.println("Incorrect input, try again stupid.\n");
			}
		}
		System.out.println();

		// Ask for models it fits. It will use a comma as a delimiter in order
		// to split the string into a string array
		Scanner console2 = new Scanner(System.in);
		console2.useDelimiter(" ");
		System.out
				.println("Enter the models the part fits separated with a comma");
		String modelString = console2.nextLine();
		models = modelString.split(",");

		System.out.println();
		console.nextLine();

		// ask for years of each model. It asks for each model.
		years = new String[models.length];

		// for the length of the array..put the years into the String array
		// years
		for (int i = 0; i < models.length; i++) {
			System.out.println("Enter year range for " + models[i]
					+ " eg. 1999-2000 : ");
			years[i] = console.nextLine();
		}
		System.out.println();

		// ask price
		// console.nextLine(); // clear console

		if (!specialItem) {
			System.out.println("\nCost?");
			cost = console.nextDouble();
			System.out.println();
			console.nextLine();
		}

		// console.nextLine();
		// ask if want to add to meta keywords. If n or 0, meta is empty string
		System.out.println("Extra Meta? (input or n/0/enter)");
		meta = console.nextLine();
		if (meta.equalsIgnoreCase("n") || meta.equals("0")) {
			meta = "";
		}
		System.out.println();

		// console.nextLine();
		// Ask if need preceding info. If n or 0, extraInfo is empty String
		System.out.println("Extra info (top)? input or n/0/enter");
		extraInfo = console.nextLine();
		if (extraInfo.equalsIgnoreCase("n") || extraInfo.equals("0")) {
			extraInfo = "";
		}

		// console.nextLine();
		// Ask if need anteceeding info. If n or 0, extraInfo is empty String
		System.out.println("Extra info (bottom)? input or n/0/enter");
		extraInfo2 = console.nextLine();
		if (extraInfo2.equalsIgnoreCase("n") || extraInfo2.equals("0")) {
			extraInfo2 = "";
		}
	}

	public static void print() {

		// Print name
		// Name is the name of the product with product number and models it
		// fits
		System.out.println("\n***Name***\n");
		System.out.print(name + " (" + productNum + ")");

		if (!usedItem) {
			System.out.print(" - " + models[0]);

			for (int i = 1; i < models.length; i++) {
				System.out.print(", " + models[i]);
			}
		}
		// if used or rebuilt
		if (usedItem) {
			System.out.print(" - USED");
		} else if (rebuiltItem) {
			System.out.print(" - REBUILT");
		}
		System.out.println("\n");

		// Print Description
		// Desc print clearance if true, extra info, application, phone number,
		// and product number
		System.out.println("***Description***\n");

		// if specialItem == true, print...
		if (specialItem) {
			// Print special Item type in red
			String special = "";
			if (clearanceItem) {
				special = "Clearance Item";
			} else if (usedItem) {
				special = "Used Item";
			} else if (rebuiltItem) {
				special = "Rebuilt Item";
			}
			System.out.println("<font color = \"red\">---" + special
					+ "---</font></br>");
		}
		if (!extraInfo.equals("")) {
			System.out.println(extraInfo + "</br>");
		}

		// Print applications

		System.out.print("<strong>Fits SAAB ");
		System.out.print(models[0] + " ");
		System.out.print("(" + years[0] + ")");

		for (int i = 1; i < models.length; i++) {
			System.out.print(", " + models[i] + " ");
			System.out.print("(" + years[i] + ")");
		}

		System.out.println("</strong></br>");

		// Static stuff...
		/*
		 * System.out
		 * .println("If you are not sure if this part fits your vehicle, " +
		 * "please feel free to call us at (888) 762-4883.  </br> ");
		 */
		// Product number
		System.out.println("Product #: " + productNum + "</br>");

		// SKU if used or rebuilt
		if (usedItem || rebuiltItem) {
			System.out.print("SKU: ");
			if (usedItem) {
				System.out.print("U" + productNum);
			} else {
				System.out.print("R" + productNum);
			}
			System.out.println("</br>");
			System.out.println("Sold as is. </br>");
		}
		if (!extraInfo2.equals("")) {
			System.out.println(extraInfo2 + "</br>");
		}

		System.out.println();

		// Short Description
		// SAAB + name + product number + models
		System.out.println("***Short Description***\n");
		System.out.print("SAAB " + name + " " + productNum + " for ");
		System.out.print(models[0] + " ");
		for (int i = 1; i < models.length; i++) {
			System.out.print(", " + models[i]);
		}
		System.out.println("\n");

		// Prints SKU number to be copied into the thingy
		System.out.println("***SKU***\n");

		// if used or refurb, print U or R preceeding the SKU
		if (usedItem) {
			System.out.print("U");
		} else if (rebuiltItem) {
			System.out.print("R");
		}

		System.out.println(productNum);
		System.out.println("\n");

		// Print sale price (marked up) and cost
		if (!specialItem) {
			System.out.print("Sale: ");
			System.out.println(cost + (cost * MARK_UP));
			System.out.println("Cost: " + cost);
			System.out.println();
		}

		// Print Meta Info

		// Print Meta title
		System.out.println("***Meta Title***\n");
		System.out.println("SAAB " + name + " " + productNum + "\n");

		// Print Meta Keywords - keep it short!
		System.out.println("***Meta Keywords***\n");
		System.out.println(name + " " + productNum + " "
				+ "saab boston volvo oem genuine "
				+ "900 9000 9-3 9-5 93 95 93 95" + meta + " \n");

		// Print meta description - keep it short!
		System.out.println("***Meta Description***\n");
		System.out.print("SAAB " + name + " " + productNum + " for ");
		System.out.print(models[0] + " ");

		for (int i = 1; i < models.length; i++) {
			System.out.print(", " + models[i]);
		}

		System.out
				.println(" Buy from the most experienced Saab parts experts"
						+ " in America! The right part at the best price -- guaranteed!\n");
	}

}
