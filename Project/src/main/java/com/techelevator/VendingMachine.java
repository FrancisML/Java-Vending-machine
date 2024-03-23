package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachine {

	private static final Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);
		processMainMenu();
	}

	public static void processMainMenu() throws FileNotFoundException {
		MainMenu mainMenu = new MainMenu();
		Inventory inventory = new Inventory();

		mainMenu.getMainMenu();
		String mainMenuChoice = userInput.nextLine();
		do {
			if (mainMenuChoice.equals("1")) {
				inventory.displayItems();
				System.out.println("*************end of items*************");
				System.out.println("*********Printing Main Menu Again *******************");
				mainMenu.getMainMenu();
				mainMenuChoice = userInput.nextLine();
			} else if(mainMenuChoice.equals("2")) {
				Purchase purchase = new Purchase();
				Money money = new Money();
				processPurchaseMenu(purchase,money);
			}
		} while (!mainMenuChoice.equals("3"));

		if (mainMenuChoice.equals("3")) {
			System.out.println("Exiting the Vending Machine. Enjoy your drink or whatever!");
			System.exit(0);
		}
	}

	public static void processPurchaseMenu(Purchase purchase, Money money) throws  FileNotFoundException {
		System.out.println("in purchase entrance");
		purchase.getPurchaseMenu();
		System.out.println("Enter your choice from the purchase options?");

		String purchaseMenuChoice = userInput.nextLine();

		if (purchaseMenuChoice.equals("1")) {
			boolean continueFeedingMoney = true;
			do {
				System.out.println("Feed the money in whole dollar amounts.");
				String userEnteredDollarsString = userInput.nextLine();
				int userEnteredDollars = Integer.parseInt(userEnteredDollarsString);
				money.feedMoney(userEnteredDollars);
				System.out.println("Do you want to continue feeding the money? Enter 'Yes' or 'No'!");
				String userContinueFeedingMoneyChoice = userInput.nextLine();
				if(userContinueFeedingMoneyChoice.equalsIgnoreCase("No")) {
					continueFeedingMoney = false;
					goToPurchaseMenu(purchase,money);				}
			} while(continueFeedingMoney);
		} else if (purchaseMenuChoice.equals("4")) {
			System.out.println(money.getBalance());
		} else {
			goToMainMenu();
		}
	}

	 public static void goToMainMenu() throws FileNotFoundException {
		System.out.println("Going to main menu now.");
		processMainMenu();
	}

	public static void goToPurchaseMenu(Purchase purchase, Money money) throws FileNotFoundException {
		System.out.println("Going to purchase menu now. Enter your choice?");
		processPurchaseMenu(purchase,money);
	}
}
