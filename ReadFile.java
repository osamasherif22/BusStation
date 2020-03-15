package files;
import java.io.*;
import java.lang.*;
import java.util.*;
import algoritm.*;
public class ReadFile {
	//private Scanner x;
	public Scanner openFile(String filename)
	{
		Scanner x=null;
		try {
			x=new Scanner(new File(filename));
		}catch (Exception e) {
			System.out.println("nnn");
		}
		return x ; 
	}
	
	public ArrayList<Trip> readTrips(Scanner x)
	{

		   ArrayList<Trip> tripList = new ArrayList<>();

		while(x.hasNext())
		{
			Trip temp=new Trip(/*x.next(),x.next(),x.next(),x.next(),x.next(),x.next()*/);
			temp.setId(x.next());
			temp.setSource(x.next());
			temp.setDestination(x.next());
			temp.setDate(x.next());
			temp.setTime(x.next());
			//temp.setNumOfSeats(Integer.valueOf(x.next()));
			temp.setDestance(x.next());
			temp.setVehicleType(x.next());
			//System.out.println(temp.getId()+" "+temp.getDate());
			tripList.add(temp);
		}
	//	
		return tripList;
	}

	public ArrayList<Ticket> readTicket(Scanner fileScanner,ArrayList<Trip> tripList)
	{
		   ArrayList<Ticket> ticketlist = new ArrayList<>();

		while(fileScanner.hasNextLine())
		{
			String line = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			while (lineScanner.hasNext()) 
			{
				Ticket temp=new Ticket(/*x.next(),x.next(),x.next(),x.next(),x.next(),x.next()*/);
				temp.setNumberOfTicket(Integer.parseInt(lineScanner.next()));
				temp.setbookedSeats(Integer.parseInt(lineScanner.next()));
				temp.setPrice(Integer.parseInt(lineScanner.next()));
				temp.setTicketType(lineScanner.next());
				
				String token;
				//if there is trip1 in this ticket
			    try
			    {
			    	 token = lineScanner.next();
			    	 if  ( token.isEmpty()==false)
					    {
					    	temp.setTrip1(Trip.getTripByID(tripList,token));
					    	temp.getTrip1().setNumOfSeats(temp.getTrip1().getVehicleType().getNumOfSeats()-temp.getbookedSeats());
					    }
			    	 //if there is trip2 in ticket
			    	 try {
					    	token = lineScanner.next();
					    	if  ( token.isEmpty()==false)
						    {
						    	temp.setTrip2(Trip.getTripByID(tripList,token));
						    	temp.getTrip2().setNumOfSeats(temp.getTrip2().getVehicleType().getNumOfSeats()-temp.getbookedSeats());

						    	//token = lineScanner.next();
						    }
					    

					    }catch (Exception e) {
							// TODO: handle exception
						}		

			    }catch (Exception e) {
					// TODO: handle exception
				}
			ticketlist.add(temp);
			}
			 lineScanner.close();    	    

		}
		return ticketlist;
	}
		
	public ArrayList<Customer> readCustomer(Scanner fileScanner,ArrayList<Ticket> ticketList)
	{
		   ArrayList<Customer> customerList = new ArrayList<>();

		while(fileScanner.hasNext())
		{String line = fileScanner.nextLine();
		Scanner lineScanner = new Scanner(line);
			while (lineScanner.hasNext()) 
			{
				Customer temp=new Customer(/*x.next(),x.next(),x.next(),x.next(),x.next(),x.next()*/);
				temp.setUserName(lineScanner.next());
				temp.setPassword((lineScanner.next()));
				while(lineScanner.hasNext()) 
				{ 
					temp.setCustomerTickets(Ticket.getTicketByTicketNum(ticketList,lineScanner.next()));
				}
				customerList.add(temp);
			}	
			lineScanner.close();
		}
		return customerList;
	}
	public ArrayList<Driver> readDriver(Scanner fileScanner,ArrayList<Trip> tripList)
	{		   ArrayList<Driver> listofDriver = new ArrayList<>();

		while(fileScanner.hasNext())
		{String line = fileScanner.nextLine();
		Scanner lineScanner = new Scanner(line);
			while (lineScanner.hasNext()) 
			{
				Driver temp=new Driver();

				temp.setUserName(lineScanner.next());
				temp.setPassword((lineScanner.next()));
				while(lineScanner.hasNext()) 
				{ 
					temp.setDriverTrips(Trip.getTripByID(tripList,lineScanner.next()));
				}
				listofDriver.add(temp);

			}	
			lineScanner.close();
		}
		return listofDriver;
	}
	
	public void closeFile(Scanner x) 
	{
		x.close();
	}
}
