package algoritm;

import java.util.*;

public interface CustomerAction 
{
		/**
		* Customer can search for trips and list them based on some criteria
		*
		*@param filter
		* used to handle trip search
		* if null, then return all trips
		*@return list of trips that matches the search criteria
		*/
		//public ArrayList<Trip> listTrips(Map<String,Object> filter);
	public ArrayList<Trip> listTrips(String source,String destination,String vehicleType,ArrayList<Trip> tripList);
		/**
		*@param selected
		* the selected trip by the customer
		*@param selected2
		* this parameter will be null if one-way trip
		*@paramnumOfSeats
		* if null, check for a single available seat
		*@return true if there is available seats
		*/
	public boolean available(Trip selected, Trip selected2, Integer numOfSeats) ;
		/**
		*@param selected
		* the selected trip by Customer
		*@param selected2
		* this parameter will be null if one-way trip
		*@param customer
		* the customer currently using the system
		*@paramnumOfSeats
		* it can't be null, and it must be > 0
		*@return the ticket with the total amount of money paid
		*/
	public Ticket reserve(Trip selected, Trip selected2, Customer customer,int numOfSeats) ;

}