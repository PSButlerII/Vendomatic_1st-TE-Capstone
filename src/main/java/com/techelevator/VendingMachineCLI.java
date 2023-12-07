package com.techelevator;

import java.util.Scanner;
import java.util.UUID;

/*
 * This class is provided to you as a *suggested* class to start
 * your project. Feel free to refactor this code as you see fit.
 */
public class VendingMachineCLI {

	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run() {
		Logger logger = new Logger("C:\\Users\\Student\\workspace\\pairs\\java-purple-minicapstonemodule1-team5\\log.txt");

		System.out.println(
				" ___      ___ _______   ________   ________  ________                 _____ ______   ________  _________  ___  ________          ________  ________  ________     \n" +
				"|\\  \\    /  /|\\  ___ \\ |\\   ___  \\|\\   ___ \\|\\   __  \\               |\\   _ \\  _   \\|\\   __  \\|\\___   ___\\\\  \\|\\   ____\\        |\\   __  \\|\\   __  \\|\\   __  \\    \n" +
				"\\ \\  \\  /  / | \\   __/|\\ \\  \\\\ \\  \\ \\  \\_|\\ \\ \\  \\|\\  \\  ____________\\ \\  \\\\\\__\\ \\  \\ \\  \\|\\  \\|___ \\  \\_\\ \\  \\ \\  \\___|        \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\|\\  \\   \n" +
				" \\ \\  \\/  / / \\ \\  \\_|/_\\ \\  \\\\ \\  \\ \\  \\ \\\\ \\ \\  \\\\\\  \\|\\____________\\ \\  \\\\|__| \\  \\ \\   __  \\   \\ \\  \\ \\ \\  \\ \\  \\            \\ \\   __  \\ \\  \\\\\\  \\ \\  \\\\\\  \\  \n" +
				"  \\ \\    / /   \\ \\  \\_|\\ \\ \\  \\\\ \\  \\ \\  \\_\\\\ \\ \\  \\\\\\  \\|____________|\\ \\  \\    \\ \\  \\ \\  \\ \\  \\   \\ \\  \\ \\ \\  \\ \\  \\____        \\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \n" +
				"   \\ \\__/ /     \\ \\_______\\ \\__\\\\ \\__\\ \\_______\\ \\_______\\              \\ \\__\\    \\ \\__\\ \\__\\ \\__\\   \\ \\__\\ \\ \\__\\ \\_______\\       \\ \\_______\\ \\_______\\ \\_______\\\n" +
				"    \\|__|/       \\|_______|\\|__| \\|__|\\|_______|\\|_______|               \\|__|     \\|__|\\|__|\\|__|    \\|__|  \\|__|\\|_______|        \\|_______|\\|_______|\\|_______|\n" +
				"                                                                                                                                                                  \n" +
				"                                                                                                                                                                  \n" +
				"                                                                                                                                                                  ");

		MainMenu menu =	new MainMenu();
		Scanner scanner = new Scanner(System.in);
		boolean keepRunning = true;
		UUID uuid = UUID.randomUUID();
		// Using the loop that Eric recommended
		while(keepRunning){
			System.out.println("WELCOME \nPlease make a selection.\n");
			menu.mainMenu(logger);
			try{
				int userInput = Integer.parseInt(scanner.nextLine());
				if(userInput<0){
					System.out.println("Positive whole number only please!! Please try again...");
					System.out.println("\nPlease make a selection.\n");
					userInput= Integer.parseInt(scanner.nextLine());
				}
				if( userInput>3){
					System.out.println("Not a valid Entry!! Please try again...");
					System.out.println("\nPlease make a selection.\n");
					userInput= Integer.parseInt(scanner.nextLine());
				}
				keepRunning = menu.sendUserInput(userInput);
				if(!keepRunning){
					break;
				}
			}
			catch(NumberFormatException nfe){
				System.out.println("Not A valid number!");
			}
		}
	}
}
