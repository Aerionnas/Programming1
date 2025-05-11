package Programming1;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * This Program calculates the average weekly tax withholding for a customer based on specified conditions.
 * 
 * Author: Aerionna Stephenson
 * Date: April 12, 2025
 */
public class WithHoldingTaxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); //scanner initialized to take in user input
		double income = 0;
		
		while(true) {
			System.out.println("Please enter your weekly income.");
			try {
				
				income = scanner.nextDouble(); // this is the user's weekly income
				
				if(income < 0) {
					System.out.println("This number cannot be negative.");
				}
				
				else {
					break; //if valid input is entered
				}
			}catch (InputMismatchException e) {
				System.out.println("Your input is invalid. Please enter a valid input.");
				scanner.next();
			}
		}
		
		
	
		double taxRate = calculateTaxRate(income); //this is the percentage in decimal form of their tax rate
		double taxesTakenOut = calculateTaxesTakenOut(taxRate, income);
		double takeHomePay = calculateTakeHomePay(income, taxRate, taxesTakenOut);
		
				

	}
	
	public static double calculateTaxRate(double income) {
		
		/*
		 * I chose to use an if- else if - else statement because multiple conditions were evaluated.
		 * The first condition that is proven true, the corresponding block of code will execute.
		 */
		
		if(income < 500) {
			System.out.println("Your tax rate is 10 percent.");
			return .10;
		}
		
		else if (income >= 500 && income < 1500) {
			System.out.println("Your tax rate is 15 percent.");
			return .15;
		}
		
		else if(income >= 1500 && income < 2500) {
			System.out.println("Your tax rate is 20 percent.");
			return .20;
		}
		
		else {
			System.out.println("Your tax rate is 30 percent.");
			return .30;
		}
	}
	
	
	public static double calculateTaxesTakenOut(double taxRate, double income) {
		double taxesTakenOut = income * taxRate;
		//this simply prints out how much money is being taken out and how much the user has after the taxes are taken out.
		System.out.println("$" + taxesTakenOut+ " is being take out of your paycheck each week.");
		return taxesTakenOut;
	}
	
	public static double calculateTakeHomePay(double income, double taxRate, double taxesTakenOut) {
		double takeHomePay = income - income * taxRate;
		System.out.println("This will leave you with $"  + (takeHomePay) + ".");
		return takeHomePay;
	}

}
