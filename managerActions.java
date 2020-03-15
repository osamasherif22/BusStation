package algoritm;
import java.util.ArrayList;
import java.io.*;


public interface managerActions
{

	/**
	*@return list of vehicles (3 types at least)
	*/
	public ArrayList<Vehicle>listVehicles();
	/**
	*@return list of trips
	*/
	public ArrayList<Trip>listTrips();
	/**
	*@return list of drivers
	*/
	public ArrayList<Person>listPersons();
	/**
	*@param list
	* save list of vehicles
	*/
	public void saveVehicles(ArrayList<Vehicle> list);
	/**
	*@param list
	* save list of trips
	*/
	public void saveTrips(ArrayList<Trip> list);
	/**
	*@param list
	* save list of drivers
	*/
	public void savePersons(ArrayList<Person> list);

}
	