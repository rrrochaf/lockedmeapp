package com.lockedmeapp;

import java.util.List;
import java.util.Scanner;

import com.lockedme.bo.FileBO;
import com.lockedme.bo.impl.FileBoImpl;
import com.lockedme.exception.BussinessException;

/**
 * 
 * @author Ricardo R. Rocha Filho
 *
 */
public class LockedMeApp {
	
	public static void main(String[] args) {

		welcomeScreenDisplay();

		mainMenu();

	}

	private static void mainMenu() {

		FileBO file = new FileBoImpl();

		int ch = 0;

		do {

			System.out.println("1) File names in ascending order");
			System.out.println("2) Files Manipulation");
			System.out.println("3) Close Application");

			ch = Integer.parseInt(getScanner().nextLine());

			switch (ch) {
			case 1:

				try {
					List<String> fileNamesAsc = file.getFileNamesAsc();

					for (String files : fileNamesAsc) {
						System.out.println(files);
					}
				} catch (BussinessException e) {
					e.printStackTrace();
				}

				break;

			case 2:
				manipulatingFiles();

				break;

			case 3:
				System.out.println("Thanks for using the Application");

				break;

			default:
				break;
			}

		} while (ch != 3);

	}

	private static void manipulatingFiles() {

		int ch = 0;

		do {

			System.out.println("1) Add a file to the existing directory list");
			System.out.println("2) Delete a file from the existing directory list");
			System.out.println("3) Search a file from the main directory");
			System.out.println("4) Back to the main context");
			
			ch = Integer.parseInt(getScanner().nextLine());

			switch (ch) {

			case 1:

				break;

			case 2:

				break;

			case 3:

				break;

			case 4:

				break;
			default:

				break;

			}

		} while (ch != 4);

	}

	private static void welcomeScreenDisplay() {

		System.out.println("Lockedme APP - Application Prototype in Java");
		System.out.println("Company Lockers Pvt. Ltd.");
		System.out.println("Developer : Ricardo R. Rocha Filho");
		System.out.println("Assessment Project - Simplilearn - Full stack Java Developer");
		System.out.println("");
		System.out.println("Details of the user interface : ");
		System.out.println("");
		System.out.println("First option - Return the current file names in ascending order in the root directory");
		System.out.println("");
		System.out.println("Second option -  Main functions :");
		System.out.println("1) Add a file to the existing directory list");
		System.out.println("2) Delete a file from the existing directory list");
		System.out.println("3) Search a file from the main directory");
		System.out.println("4) Back to the main context");
		System.out.println("");
		System.out.println("Third option - Close Application ");
		System.out.println();
		System.out.println("********* Press enter to continue *********");
		getScanner().nextLine();
	}

	private static Scanner getScanner() {
		return new Scanner(System.in);
	}

}