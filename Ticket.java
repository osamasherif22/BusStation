package algoritm;

import java.util.ArrayList;

public class Ticket {
	int bookedSeats;
    int price;
    int numberOfTicket;
    static int counter ;
    private	Trip trip1;
    private Trip trip2;
	String ticketType;
	Singletone all= Singletone.getInstance();;
	public static ArrayList<Ticket> ticketList = new ArrayList<>();
	
	 public static ArrayList<Ticket> getTicketList() {
		return ticketList;
	}

	public static void setTicketList(Ticket ticket) {
		Ticket.ticketList.add(ticket);
	}
	
	// Constructor 
	public Ticket(int bookedSeats, int price, String ticketType,Trip trip1, Trip trip2)
	{
		this.bookedSeats = bookedSeats;
		this.price = price;
		this.trip1 = trip1;
		this.trip2 = trip2;
		this.ticketType = ticketType;
		counter++;
		this.numberOfTicket=counter; 
	}

public Trip getTrip1() {
	return trip1;
}

public int getNumberOfTicket() {
	return numberOfTicket;
}

public void setNumberOfTicket(int numberOfTicket) {
	counter++;
	this.numberOfTicket = numberOfTicket;
}

public void setTrip1(Trip trip1) {
	this.trip1 = trip1;
}



public Trip getTrip2() {
	return trip2;
}



public void setTrip2(Trip trip2) {
	this.trip2 = trip2;
}


	public int getbookedSeats() {
		return bookedSeats;
	}



	public void setbookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getTicketType() {
		return ticketType;
	}



	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	public static Ticket getTicketByTicketNum(ArrayList<Ticket> ticketList,String numberOfTicket)
	{
	
			for (int i=0 ;i< ticketList.size();i++)
       // populate produce combo box with one to length of produce names array
	        {
	        	if (String.valueOf(ticketList.get(i).getNumberOfTicket()).equals(numberOfTicket))
	        	{
	        		return ticketList.get(i);
	        	}	
	         }
			
			return null;
	}

	public void  removeTicketByTripId(String Id)
	{
	
			for (int i=0 ;i< all.getListofTickets().size();i++)
       // populate produce combo box with one to length of produce names array
	        {
				
	        
	        	if (all.getListofTickets().get(i).getTrip1().getId().equals(Id))
	        	{
	        		all.getListofTickets().remove(all.getListofTickets().get(i));
	        	}try {
				
	        	 if (all.getListofTickets().get(i).getTrip2().getId().equals(Id))
	        	{
	        		all.getListofTickets().remove(all.getListofTickets().get(i));
	        	}
	        	
				} catch (Exception e) {
					// TODO: handle exception
				}
	         }
			
			return ;
	}
}
