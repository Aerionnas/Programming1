package Programming1;


import java.util.InputMismatchException;
import java.util.Scanner;

public class GetMonthlyTemperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		String [] month = {"January" , "February" , "March", "April", "May" , "June", "July", "August", "September", "October", "November", "December"
		};
		
		
		double [] temperature = getInputtedMonthlyTemperatures(month, scanner); 
	
		
		String response = getUserInput(scanner);
		
		if (response.equalsIgnoreCase("month")) {
			
			String monthInputted = getMonth(scanner);
			showMonthlyTemperature(temperature, month, monthInputted);
		}
		
		else if(response.equalsIgnoreCase("year")){
			
			displayYearlyStats(temperature, month);
				
		}
		
		else {
			System.out.println("You have entered an invalid input. Try again next time.");
		}

	}
	
	private static double[] getInputtedMonthlyTemperatures(String [] month, Scanner scan) {
		double [] temperature = new double[month.length];		
		for(int i = 0; i < month.length; i++) {
			System.out.println("What was the monthly temperature for the month of " + month[i] + "?");
			
			while(true) {
				if (scan.hasNextDouble()) {
					temperature[i] = scan.nextDouble();
					break;
				}
				else {
					System.out.println("You have entered an invalid input. Try again.");
					scan.next();
				}
			}
			
		}
		
		return temperature;	
		
	}
	
	private static String getUserInput(Scanner scan) {
		System.out.println("Please enter the words, month or year, to view the average temperature during that time.");
		try {
			while(true) {
				if(scan.hasNextDouble()) {
					scan.nextDouble();
					break;
				}
				
				else {
					System.out.println("Your input is invalid. Try again.");
					scan.nextDouble();
				}
			}
		}catch(InputMismatchException e) {
			return "Your input is invalid."+ e.getMessage();
		}
		
		return scan.next();
	}
	
	private static String getMonth(Scanner scan) {
		System.out.print("Which month would you like to view?");
		return scan.next();
	}
	
	private static void showMonthlyTemperature(double [] temperature, String [] month, String monthName) {
		for(int i = 0; i < month.length; i++){
			
			if(month[i].equalsIgnoreCase(monthName))
			
			System.out.println("The average temperature for the month of " + month[i] + " is " + temperature[i]+ ".");
			
		}
	}
	
	private static void displayYearlyStats(double [] temperature, String [] month){
		double total = 0;
		double highestTemp = temperature[0];
		double lowestTemp = temperature[0];
		
		for(int i = 0; i < month.length; i++) {
			
			System.out.println("The average temperature for the month of " + month[i] + " is " + temperature[i]+ ".");
			
			if(temperature[i] > highestTemp) {
				highestTemp = temperature[i];
			}
			
			if(temperature[i] < lowestTemp) {
				lowestTemp = temperature[i];
			}
			
			total += temperature[i];
			
		}
		
		System.out.println("The highest temperature for the year was " + highestTemp + ".");
		
		System.out.println("The lowest temperature for the year was " + lowestTemp + ".");
		
		System.out.println("The average temperature for the year was " + total/month.length + ".");
	
	}
	
}
