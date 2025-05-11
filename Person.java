package Programming1;

/*This program is a Person class with attributes and getters and setters.
 */
public class Person {
	
	//attributes
	private String firstName; //this is the person's first name
	private String lastName;//this is the person's last name
	private String addy;//this is the person's address
	private String city;//this is the person's city name
	private int zipcode; //this is the person's zipcode

	//constructor
	
	public Person(String firstName, String lastName, String addy, String city, int zipcode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addy = addy;
		this.city = city;
		this.zipcode = zipcode;
	}
	
	//default constructor 
	public Person() {
		super();
		this.firstName = "";
		this.lastName = "";
		this.addy = "";
		this.city = "";
		this.zipcode = 0;
	}
	
	//getters and setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddy() {
		return addy;
	}
	public void setAddy(String addy) {
		this.addy = addy;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//each variable is printed on a new line
		
		Person a = new Person("Aerionna", "Stephenson", "238 George Parks Hwy", "Healy", 99743);
		
		System.out.println(a.getFirstName());
		System.out.println(a.getLastName());
		System.out.println(a.getAddy());
		System.out.println(a.getCity());
		System.out.println(a.getZipcode());
	}

	

}
