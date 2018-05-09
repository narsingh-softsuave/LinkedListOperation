package com.softsuave.linkedlist;

import java.util.Scanner;

public class DemoApp {

	public static void main(String[] args) {
		char choice;
		Scanner ipScanner = new Scanner(System.in);
		Scanner chScanner = new Scanner(System.in);
		LinkedList list = new LinkedList();
		do {
			System.out.println("List operation\n");
			System.out.println("1. Insert a value");
			System.out.println("2. Remove tail element from the list");
			System.out.println("3. Remove all elements greater than the target value");
			int input = 0;
			try {
				input = ipScanner.nextInt();
			} catch (Exception ex) {
				System.err.println("Invalid option!");
			}

			switch (input) {
			case 1:
				System.out.println("Please input a int value:");
				int inputVal = ipScanner.nextInt();
				list.insert(inputVal);
				list.print();
				break;
			case 2:
				list.removeLastElement();
				list.print();
				break;
			case 3:
				System.out.println("Please input a int value:");
				try {
					int inputVal1 = ipScanner.nextInt();
					list.removeElementsGtThan(inputVal1);
					list.print();
				} catch (Exception e) {
					System.err.println("Error");
				}
				break;
			default:
				break;
			}
			System.out.println("\nDo you want to continue? (Press 'Y') \n");
			choice = chScanner.next().charAt(0);
		} while (choice == 'y' || choice == 'Y');
		ipScanner.close();
		chScanner.close();
	}
}
