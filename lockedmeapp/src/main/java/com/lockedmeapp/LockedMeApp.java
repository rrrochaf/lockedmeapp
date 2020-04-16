package com.lockedmeapp;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.lockedme.bo.FileBO;
import com.lockedme.bo.impl.FileBoImpl;
import com.lockedme.exception.BussinessException;
import com.lockedme.model.Archive;

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
				addFile();

				break;

			case 2:
				deleteFile();

				break;

			case 3:
				searchFile();
				break;

			case 4:
				mainMenu();
				break;
			default:

				break;

			}

		} while (ch != 4);

	}

	private static void addFile() {

		FileBO fileBO = new FileBoImpl();
		Archive archive = new Archive();

		System.out.println("Root directories in your system are:");
		listRoot(fileBO, archive);
		

		int key = 0;

		System.out.println("1) Add a file in the root");
		System.out.println("2) Add a file in another directory");
		key = Integer.parseInt(getScanner().nextLine());

		if (key == 1) {

			addFileInRoot(fileBO, archive);

		} else {

			addFileinDirectory(fileBO, archive);
		}

	}

	private static void addFileinDirectory(FileBO fileBO, Archive archive) {

		try {
			File[] directoryList = fileBO.getDirectoryList();
			for (int i = 0; i < directoryList.length; i++) {
				System.out.println(directoryList[i].toString());
			}
		} catch (IOException e) {
			e.getMessage();
		}

		System.out.println("");
		System.out.println("Type the directory of the file");
		archive.setDirectory(getScanner().nextLine());

		System.out.println("Type the name of the file");
		archive.setName(getScanner().nextLine());

		System.out.println("Type the extension of the file");
		archive.setExtension(getScanner().nextLine());

		try {
			if (fileBO.addFile(archive, false)) {
				System.out.println("File was created successfully");
			}
		} catch (BussinessException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void addFileInRoot(FileBO fileBO, Archive archive) {

		System.out.println("Type the name of the file");
		archive.setName(getScanner().nextLine());

		System.out.println("Type the extension of the file");
		archive.setExtension(getScanner().nextLine());

		try {
			if (fileBO.addFile(archive, true)) {
				System.out.println("File was created sucessfully");
			}
		} catch (BussinessException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void deleteFile() {

		FileBO fileBO = new FileBoImpl();
		Archive archive = new Archive();

		System.out.println("Root directories in your system are:");
		listRoot(fileBO, archive);

		int key = 0;

		System.out.println("1) Delete a file in the root");
		System.out.println("2) Delete a file in another directory");
		key = Integer.parseInt(getScanner().nextLine());

		if (key == 1) {

			deleteFileInRoot(fileBO, archive);

		} else {

			deleteFileInDirectory(fileBO, archive);
		}

	}

	private static void deleteFileInRoot(FileBO fileBO, Archive archive) {

		try {
			File[] rootList = fileBO.getFilesInDirectoryList(archive);
			for (int i = 0; i < rootList.length; i++) {
				System.out.println(rootList[i].toString());
			}

			System.out.println("Type the name of the file");
			archive.setName(getScanner().nextLine());

			System.out.println("Type the extension of the file");
			archive.setExtension(getScanner().nextLine());

			if (fileBO.deleteFile(archive, true)) {
				System.out.println("File was deleted sucessfully");
			}
		} catch (BussinessException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void deleteFileInDirectory(FileBO fileBO, Archive archive) {

		try {
			File[] directoryList = fileBO.getDirectoryList();
			for (int i = 0; i < directoryList.length; i++) {
				System.out.println(directoryList[i].toString());
			}

			System.out.println("");
			System.out.println("Type the directory of the file");
			archive.setDirectory(getScanner().nextLine());

			File[] rootList = fileBO.getFilesInDirectoryList(archive);
			for (int i = 0; i < rootList.length; i++) {
				System.out.println(rootList[i].toString());
			}

			System.out.println("Type the name of the file that you want to delete");
			archive.setName(getScanner().nextLine());

			System.out.println("Type the file extension");
			archive.setExtension(getScanner().nextLine());

			if (fileBO.deleteFile(archive, false)) {
				System.out.println("");
				System.out.println("File was deleted successfully");
				System.out.println("");
			}

		} catch (BussinessException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void searchFile() {

	}

	private static void listRoot(FileBO fileBO, Archive archive) {
		
		try {
			File[] rootList = fileBO.getRootList();
			for (int i = 0; i < rootList.length; i++) {
				System.out.println(rootList[i].toString());
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("Type the root of the file");
		archive.setRoot(getScanner().nextLine());

	}

	private static Scanner getScanner() {
		return new Scanner(System.in);
	}
}