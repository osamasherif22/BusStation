package algoritm;

import java.util.ArrayList;

public class Manager  extends Employee{
	
	 private static Manager instance1 = null;
	  
	 public static Manager getInstance() {
	        if (instance1 == null) {
	            instance1 = new Manager();
	        }
	        return instance1;
	    }
	
	public void reviewTrip() {
		
	}
	public ArrayList<Trip> addTrip(String id,	String source,String destination,String date,String time,String vehicleType,String destance,ArrayList<Trip> tripList) 
	{
		Trip temp=new Trip(/*x.next(),x.next(),x.next(),x.next(),x.next(),x.next()*/);
		temp.setId(id);
		temp.setSource(source);
		temp.setDestination(destination);
		temp.setDate(date);
		temp.setTime(time);
		//temp.setNumOfSeats(Integer.valueOf(x.next()));
		temp.setDestance(destance);
		temp.setVehicleType(vehicleType);
		//System.out.println(temp.getId()+" "+temp.getDate());
		tripList.add(temp);
		return tripList;
	}
	/*public ArrayList<Trip> deleteTrip(Trip trip,ArrayList<Trip> tripList) 
	{
		tripList.remove(trip);
		return tripList;
	}*/
	public Driver assignDriverToTrip(	Driver driver , Trip trip) 
	{
		driver.setDriverTrips(trip);
		return driver;
	}
	public boolean isFound(Trip trip,Driver driver)
	{
		
		for (int i=0 ;i< driver.getDriverTrips().size();i++)

		{
			if ( driver.getDriverTrips().get(i).getId().equals(trip.getId()))
					{
			return true;
					}
		}
			 return false;
	}

	public ArrayList<Trip> hasDriver (ArrayList<Trip> tripList,ArrayList <Driver> driverList) 
	{
		ArrayList<Trip> nonAssignedTrips = new ArrayList<>();
		int flag =0 ; 
		for (int i=0 ;i< tripList.size();i++)
		{
			flag =0 ; 
				for (int j=0 ;j<driverList.size();j++)
				{
					if(isFound(tripList.get(i),driverList.get(j)))
					{
						flag =1 ;
						break;
					}
		    	}
				if (flag==0)
				{
					nonAssignedTrips.add(tripList.get(i));}		

				}
		return nonAssignedTrips;
	 }
	
	public Manager(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}

	public Manager() {
		super();
	}

	


}
