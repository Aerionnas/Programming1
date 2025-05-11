package Programming1;

/*
 * This is a Automobile class that contains the following attributes: make, model, color, year, and mileage. It contains a parameterized
 * constructor, a default constructor and appropriate methods.
 * 
 * Author: Aerionna Stephenson
 * Date: May 10, 2025
 */

import java.util.ArrayList;

import java.util.List;

public class Automobile{
	//attributes
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;
	
	//ArrayList of cars that are added
	private static List<Automobile> cars = new ArrayList<>();

	//parameterized constructor
	public Automobile(String make, String model, String color, int year, int mileage) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.mileage = mileage;
	}
	
	//default constructor
	public Automobile() {
		this.make = "";
		this.model = "";
		this.color = "";
		this.year = 0;
		this.mileage = 0;
	}
	
	//getter and setters
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public static List<Automobile> getCars() {
		return cars;
	}

	public static void setCars(List<Automobile> cars) {
		Automobile.cars = cars;
	}
	

	//instance variables
	
	//vehicle object is created and added to the ArrayList based on the given fields
	public String AddVehicle(String autoMake, String autoModel, String autoColor, int autoYear, int autoMileage) {
		try {
			
			// a new instance of Automobile Objects base on the fields from the parameter
			Automobile a = new Automobile(autoMake, autoModel, autoColor, autoYear, autoMileage);
			
			for(int i = 0 ; i < cars.size() ; i++) {
				
				//this if statement checks if the ArrayList has elements inside of it and if one of those elements have the given attributes
				if ((cars.get(i) != null)  && 
						(( cars.get(i).make.equalsIgnoreCase(autoMake) ) && 
						( cars.get(i).model.equalsIgnoreCase(autoModel) ) && 
						( cars.get(i).color.equalsIgnoreCase(autoColor) ) &&
						( cars.get(i).year == autoYear ) &&
						( cars.get(i).mileage == autoMileage))){
					
					return "We already have this automobile in our system.";
				}
			}
			
			//instance a is added to the ArrayList
			cars.add(a);
			
			return "This automobile has been added to our records.";
			
		} catch (Exception e) {
			
			return "I am sorry, but this vehicle could not be added to our system." + e.getMessage();
		}
}
	
	
	//A vehicle is removed from the ArrayList if it contains the same in information in it's fields	
	public String RemoveVehicle(String autoMake, String autoModel, String autoColor, int autoYear, int autoMileage) {
		
			try {
				// checks if the ArrayLisi is empty
				if(cars.isEmpty()) {
					throw new Exception("We currently do not have any vehicles at the moment. Please come back at another time.");
				}
			
				// the list of cars is going to be traversed to ensure the values of the particular cars match the values given in the parameter
				for(Automobile car: cars) {
					if(car.getMake().equalsIgnoreCase(autoMake) &&
							car.getModel().equalsIgnoreCase(autoModel) &&
							car.getColor().equalsIgnoreCase(autoColor) &&
							car.getYear() == autoYear &&
							car.getMileage() == autoMileage){
					
						//once the correct car is found, the car is removed from the ArrayList
						cars.remove(car);
						car.setMake("");
						car.setModel("");
						car.setColor("");
						car.setYear(0);
						car.setMileage(0);
						return "This car has been removed from our records.";
					}
				}
			
				// this is returned if the car with this information could not be found
				return "This vehicle cannot be found in our records.";
			
			} catch (Exception e) {
				return e.getMessage();
			}
		}
	
	//the car's information is updated using the information from the fields in the parameter
	public String updateAutomobileInfo(String autoMake, String autoModel, String autoColor, int autoYear, int autoMileage) {
	
		try {
			setMake(autoMake);
			setModel(autoModel);
			setColor(autoColor);
			setYear(autoYear);
			setMileage(autoMileage);
		
			// the information is for the car is updated
			return "The information for this automobile has been updated";
	
		} catch (Exception e) {
			return "I am sorry, but my system is not letting me update the information for this automobile." + e.getMessage();
		}
	
	
	}

	// the information for the automobile is listed in a String array format
	public String[] listAutomobileInformation() {
		try {
			//I included this line as a test to make sure that the information was being inputed properly
//			System.out.println("This is a " + color + " "+ make + " " + model + " that was manufactured in "+ year + ". It currently has " + mileage + " miles on it.");
			return new String[] {make, model, color, String.valueOf(year), String.valueOf(mileage) };
	
		} catch (Exception e) {
			return new String [] {"I am sorry, but this vehicle could not be added to our system." + e.getMessage()};
		}	
	
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
