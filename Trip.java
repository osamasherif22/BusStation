package algoritm;

import java.util.ArrayList;

public class Trip {
	String id;
	String source;
	String destination;
	String date;
	String time;
	Vehicle vehicleType ;
     int  numOfSeats;
	String destance;
	
	public static Trip getTripByID(ArrayList<Trip> tripList,String Id)
	{
	
			for (int i=0 ;i< tripList.size();i++)
       // populate produce combo box with one to length of produce names array
	        {
	        	if (tripList.get(i).getId().equals(Id))
	        	{
	        		return tripList.get(i);
	        	}	
	         }
			
			return null;
	}
	public String getDestance() {
		return destance;
	}
	public void setDestance(String destance) {
		this.destance = destance;
	}
	/*public void printTripList(ArrayList<Trip> tripList)
	{
		
	}*/
	public Trip(String id, String source, String destination, String date, String time, String vehicleType,
		/*int numOfSeats, */String destance) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.time = time;
		if (vehicleType.equals("bus"))
		{
				this.vehicleType=new Bus();
		}
		else if (vehicleType.equals("mini-bus"))
		{
			this.vehicleType=new MiniBus();
		}
		else if (vehicleType.equals("Limousine"))
		{
			this.vehicleType=new Limousine();
		}
		this.numOfSeats =this.vehicleType.getNumOfSeats();
		this.destance = destance;
	}
	public Trip() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public int getNumOfSeats() {
		return numOfSeats;
	}
	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Vehicle getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		if (vehicleType.equals("bus"))
		{
				this.vehicleType=new Bus();
		}
		else if (vehicleType.equals("mini-bus"))
		{
			this.vehicleType=new MiniBus();
		}
		else if (vehicleType.equals("Limousine"))
		{
			this.vehicleType=new Limousine();
		}
		setNumOfSeats(this.vehicleType.getNumOfSeats());		
	}
}
