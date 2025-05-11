package Programming1;

import java.awt.Desktop;
/*
 * This is a Automobile Inventory class runs all the methods from the Automobile class. It also allows the users to send information to a file.
 * 
 * Author: Aerionna Stephenson
 * Date: May 10, 2025
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AutomobileInventory {
	static Scanner scanner = new Scanner (System.in);
	
	//I kept rewriting this code, so I just made a method to print the car's information from the listAutomobileInformation() method
	public static void printArrayValues(Automobile c) {
		//String array named arr is assigned the array that is returned from the listAutomobileInformation() method
		String [] arr = c.listAutomobileInformation();
		//the array is traversed and the information is printed out
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	//the information from the array is printed to a file
	private static void printToFile( String [] info) {
		try {
			//specified file location
			String file = "C:\\Temp\\Autos.txt";
			BufferedWriter write = new BufferedWriter(new FileWriter(file));
				for(String line : info) {
					//the information on that line is written to file
					write.write(line);
					//the lines are separated by a line of white space
					write.newLine();
				}
				write.newLine();
				//needed to include this line so the information would actually write to file
				write.close();
			
		}catch (IOException e) {
			System.out.println("I am sorry, but we experienced and error transferring this car's information to a file" +e.getMessage());
		}
	}
	
	//asks user if they want the information printed to file and decides whether print the information based on the user's response
	private static void askToPrintToFile(String [] info) {
		//specified file
		String file = "C:\\Temp\\Autos.txt"; 
		//ask user if they want the car's information printed to file
		System.out.println("Would you to print the information to a separate file? Please enter Y or N.");
		//user's response
		String response = scanner.next();
		//if yes, the printToFile method will be called and the file will open automatically
		if (response.equalsIgnoreCase("Y")) {
			printToFile(info);
			openFile(file);
	
			System.out.println("This car's information was written to a file.");
			
		}
		
		else if(response.equalsIgnoreCase("N")) {
			System.out.println("Fine. We will not print the car's information to a file.");
		}
			
		else {
			System.out.println("You put in invalid response. Unfortunately, we cannot write this car's information to a file.");
		}
			
		
	}
	
	//this method opens the file automatically after the information is written
	 private static void openFile(String filePath) {
	
		 
		         try {
		        	 //it gets the desktop instance of the current browser context
		        	 Desktop desktop = Desktop.getDesktop();
		        	 
		        	 //takes in the specified location
		             File file = new File(filePath);
		 
		             //checks if the file does not exist
		             if (!file.exists()) {
		
		                 System.err.println("File does not exist: " + filePath);
		 
		                 return;
		 
		             }
		 
		             //checks if the desktop is supported on the current platform
		             if (!Desktop.isDesktopSupported()) {
		 
		                 System.err.println("Desktop is not supported on this platform.");
		 
		                 return;
		 
		             }
		 
		 
		             
		             //the desktop opens the file
		             desktop.open(file);
		 
		             System.out.println("File has been opened.");
		 
		         } catch (IOException e) {
		 
		             System.err.println("Failed to open file: " + e.getMessage());
		 
		         }
		 
		     }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//automobile a is created
		Automobile a = new Automobile("Toyota" , "Corolla", "blue" , 2011, 50000 );
		
		//add vehicle
		System.out.println(a.AddVehicle(a.getMake(),a.getModel(), a.getColor(), a.getYear(), a.getMileage()));
		
		printArrayValues(a);
		
		askToPrintToFile(a.listAutomobileInformation());
		
		//remove vehicle
		System.out.println(a.RemoveVehicle(a.getMake(),a.getModel(), a.getColor(), a.getYear(), a.getMileage()));
		
		//checks if the array is empty(if it it is empty, we do not have any cars)
		
//		System.out.println(a.RemoveVehicle(a.getMake(),a.getModel(), a.getColor(), a.getYear(), a.getMileage()));

		
		Automobile b = new Automobile("Ford" , "Fusion", "white" , 2019, 40000 );
		
		System.out.println(b.AddVehicle(b.getMake(), b.getModel() , b.getColor() ,b.getYear() , b.getMileage()));
		
		printArrayValues(b);
		
		askToPrintToFile(b.listAutomobileInformation());
		
		System.out.println(b.updateAutomobileInfo("Ford", "Fusion", "blue", 2020, 30000));
		
	
		printArrayValues(b);
		
		askToPrintToFile(b.listAutomobileInformation());

		
		

	}

}
	



