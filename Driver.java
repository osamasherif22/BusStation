package algoritm;

import java.util.ArrayList;

public class Driver extends Employee {
	String name ;
	String Age ;
	private static Driver instance1 = null;
	  
	 public static Driver getInstance() {
	        if (instance1 == null) {
	            instance1 = new Driver();
	        }
	        return instance1;
	    }	
	 
	public void setAge(String age) {
			Age = age;
		}
	public String getAge() {
		return this.Age;
	}

ArrayList <Trip> driverTrips = new ArrayList<>();

	public ArrayList<Trip> getDriverTrips() {
	return driverTrips;
}


public void setDriverTrips(Trip trip) {
	this.driverTrips.add(trip);
}


	public void showTrip() {}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Driver(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}
	
}
