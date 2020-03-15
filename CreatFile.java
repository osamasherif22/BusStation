package files;
import java.io.*;
import java.lang.*;
import java.util.*;

import algoritm.*;
import algoritm.Trip;
public class CreatFile {
//	private Formatter trip;
	//private Formatter driver;
	public Formatter openFile(String filename)
	{	Formatter x = null;
		try {
			x=new Formatter(filename);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return x ; 
	}
	public void saveTrips(ArrayList<Trip> tripList,Formatter x) {
		System.out.println("trip"+tripList.size());

		String newline =System.getProperty("line.separator");
		tripList.forEach(Trip ->
		{
			x.format("%s %s %s %s %s %s %s", Trip.getId(),Trip.getSource(),Trip.getDestination(),Trip.getDate(),Trip.getTime(),Trip.getDestance(),Trip.getVehicleType().getVehicleType());
			x.format(newline);
		});
		
	}
	public void saveDrivers(ArrayList<Driver> driverList,Formatter x) {
		System.out.println("driver"+driverList.size());

		driverList.forEach(Driver ->
		{
			String newline =System.getProperty("line.separator");
			x.format("%s %s", Driver.getUserName(),Driver.getPassword());
		
			Driver.getDriverTrips().forEach(Trip->
			{
				x.format(" %s", Trip.getId());
			});
			x.format(newline);
		});
		
	}
	
	public void saveTickets(ArrayList<Ticket> ticketList,Formatter x) {
		System.out.println("ticket"+ticketList.size());
		String newline =System.getProperty("line.separator");

		ticketList.forEach(Ticket ->
		{
			try {
				
			x.format("%d %s %d %s %s %s",Ticket.getNumberOfTicket(), Ticket.getbookedSeats(),Ticket.getPrice(),Ticket.getTicketType(),Ticket.getTrip1().getId(),Ticket.getTrip2().getId());
			} catch (Exception e) {
			x.format("%d %s %d %s %s",Ticket.getNumberOfTicket(), Ticket.getbookedSeats(),Ticket.getPrice(),Ticket.getTicketType(),Ticket.getTrip1().getId());
			}
			x.format(newline);
		});
		
	}
	public void saveCustomer(ArrayList<Customer> customerList,Formatter x) {
		System.out.println("customer"+customerList.size());
		String newline =System.getProperty("line.separator");

		customerList.forEach(Customer->
		{
			x.format("%s %s", Customer.getUserName(),Customer.getPassword());
			try {
			Customer.getCustomerTickets().forEach(Ticket->{
				x.format(" %d", Ticket.getNumberOfTicket());
			});
			
			} catch (Exception e) {
				// TODO: handle exception
			}
			x.format(newline);
		});
	}

	public void closeFile(Formatter x) {
		x.close();
	}
}
