package Programming1;


import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * This program asks the user for 10 grades from a class test. Based on the data given by the user, 
 * it prints out the minimum, maximum, and average grade. 
 * 
 * Author: Aerionna Stephenson
 * Date: April 4, 2025
 */

public class ClassStatistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
	
		double total = 0;
		
		System.out.println("How many grades would you like to enter?");
		int numOfGrades = scanner.nextInt();
		double grade;
		double firstGrade = getGrade(scanner);
		double max = firstGrade; //initializes the first grade entered by the user as the max
		double min = firstGrade; //initializes the first grade entered by the user as the min
		total += firstGrade;
		
		
		//this for loop will ask the user 9 more times to enter a grade since we have have asked once before already
		for(int i=0; i<numOfGrades-1; i++) {
			
			grade = getGrade(scanner);
			min= grade;
			
			//if another max is discovered, the grade becomes the new max
			if(grade > max) {
				max = grade;
			}
			
			//if another max is discovered, the grade becomes the new max
			if(grade < min) {
				min = grade;
			}
			
			total += grade;
			
		}
		
		System.out.println("The highest grade was a " + max + "%.");
		System.out.println("The lowest grade was a " + min + "%.");
		System.out.println("The average grade was a " + total / numOfGrades + "%.");  // divide the total by the number of grades to get the average

	}
	
	public static double getGrade(Scanner scan) {
		double grade;
		while (true) {
			System.out.println("Please enter a grade between 0 and 100");
			try {
				grade = scan.nextDouble();
				if(grade < 0 || grade > 100) {
					System.out.println("Your input must be in between 0 and 100. Please try again.");
					continue;
				}
	
				return grade;
				
			}catch(InputMismatchException e) {
				System.out.println("You entered an invalid input.");
				scan.nextDouble();
			}
		}
		
		
	}
	
	


}
