package algoritm;

public abstract class Vehicle 
{
	int numOfSeats;
	String vehicleType;

	public Vehicle(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats)
	{
		this.numOfSeats = numOfSeats;
	}
	public abstract String getVehicleType();
	{
	}
	
}
