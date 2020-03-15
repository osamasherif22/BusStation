package algoritm;

import java.util.ArrayList;


public class Singletone {
	
	private static Singletone instance1 = null;
	 public static Singletone getInstance() {
	        if (instance1 == null) {
	            instance1 = new Singletone();
	        }
	        return instance1;
	    }
	ArrayList<Trip> tripList ;
	ArrayList<Driver>  listofDriver ;
	ArrayList<Customer> customerList;
	ArrayList<Ticket>  ticketlist ;
	
	public ArrayList<Trip> getTripList() {
		return tripList;
	}
	
	public Singletone() {
		super();
	}

	public Singletone(ArrayList<Trip> tripList, ArrayList<Driver> listofDriver, ArrayList<Customer> customerList,
			ArrayList<Ticket> ticketlist) {
		super();
		this.tripList = tripList;
		this.listofDriver = listofDriver;
		this.customerList = customerList;
		this.ticketlist = ticketlist;
	}
	public void setTripList(ArrayList<Trip> tripList) {
		this.tripList = tripList;
	}
	public ArrayList<Driver> getListofDriver() {
		return listofDriver;
	}
	public void setListofDriver(ArrayList<Driver> listofDriver) {
		this.listofDriver = listofDriver;
	}
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	public ArrayList<Ticket> getListofTickets() {
		return ticketlist;
	}
	public void setListofTickets(ArrayList<Ticket> listofTickets) {
		this.ticketlist = listofTickets;
	}
	


}
