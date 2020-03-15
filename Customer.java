package algoritm;
import java.util.*;

public class Customer extends Person implements CustomerAction
{	
public static Customer instance1 = null;
public static Customer getInstance() {
      if (instance1 == null) {
    		System.out.println("first");
          instance1 = new Customer();
      }
  	System.out.println("original");

      return instance1;
  }
Singletone all=Singletone.getInstance();

	
	private ArrayList<Ticket> customerTickets=new ArrayList<>();



public  int calculatePrice (String distance ,int numOfSeats)
{
	return ((Integer.valueOf(distance)*2)*numOfSeats)/10;	
}
	public ArrayList<Ticket> getCustomerTickets() {
	try {
		if (customerTickets.get(0)==null) return null;	} 
	catch (Exception e) {
		return null;
		}
	 return customerTickets;
	
				}

public void setCustomerTickets(Ticket ticket) {
	this.customerTickets.add(ticket);
}


	
	public Customer() {
	super();
}
	public ArrayList<Trip> listTrips(String source,String destination,String vehicleType,ArrayList<Trip> tripList)
	{
	    	ArrayList<Trip> foundList = new ArrayList<>();
	    	if (source.equals("")&&destination.equals("")) return tripList;
			
	    	tripList.forEach(Trip -> {
	    	 if(Trip.destination.equalsIgnoreCase(destination)||Trip.destination.equals(""))
	    		{
	    			if(Trip.source.equalsIgnoreCase(source)||Trip.source.equals(""))
	    			{
	    				 if(Trip.vehicleType.getVehicleType().equalsIgnoreCase(vehicleType)||Trip.vehicleType.getVehicleType().equals(""))
	 				  
	    					{
	    						foundList.add(Trip);
	    					}
	    				 
	    			}
	      		}
	    	 else
	    		 return ;
	   	});
			return foundList;
	}
		public Customer(String userName, String password) {
			super(userName, password);
			// TODO Auto-generated constructor stub
	}
	public boolean available(Trip selected, Trip selected2, Integer numOfSeats) {
		if (numOfSeats==null)
		{
			numOfSeats=1 ;
		}
		
		if (selected2==null)
		{
		//	if ( numOfSeats == null)
				if (selected.getNumOfSeats()>=numOfSeats)
					return true;
		}
		else
		{
			
			if ((selected.getNumOfSeats()>=numOfSeats)&&(selected2.getNumOfSeats()>=numOfSeats))
					return true;
		}
		return false;
	}
public Ticket reserve(Trip selected, Trip selected2, Customer customer,int numOfSeats) 
	
	{
	  Ticket ticket;
            	if (selected==null&&selected2==null)
              	return null;
				if (selected2==null)
				{
					System.out.println("Single");

					ticket=new Ticket(numOfSeats,calculatePrice(selected.getDestance(),numOfSeats),"S",selected,selected2);
					//customer.setCustomerTickets(ticket);
					selected.setNumOfSeats(selected.getNumOfSeats()-numOfSeats);
				}
				else 
					 {
					System.out.println("Round");
						ticket=new Ticket(numOfSeats,calculatePrice(selected.getDestance(),numOfSeats)+calculatePrice(selected.getDestance(),numOfSeats),"R",selected,selected2);
						//customer.setCustomerTickets(ticket);
						selected2.setNumOfSeats(selected2.getNumOfSeats()-numOfSeats);
						selected.setNumOfSeats(selected.getNumOfSeats()-numOfSeats);

					 }
				all.getListofTickets().add(ticket);
			return ticket;
	
	}
	
}