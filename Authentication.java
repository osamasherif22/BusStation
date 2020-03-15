package algoritm;

import java.util.ArrayList;

public class Authentication {
	public static int getCustomerIndex(String userName ,String password, ArrayList<Customer> customerList)
	{
		for (int i=0 ;i< customerList.size();i++)
		{
			if ( customerList.get(i).getUserName().equals(userName))
				{
				if ( customerList.get(i).getPassword().equals(password))

					{
					return i ; 
					}
				}
		}
		return -1;
	}
	public static int getDriverIndex(String userName ,String password, ArrayList<Driver> driverList)
	{
		for (int i=0 ;i< driverList.size();i++)
		{
			if ( driverList.get(i).getUserName().equals(userName))
			{
				if ( driverList.get(i).getPassword().equals(password))
				{
					return i ; 
				}
			}
		}
		return-1;
	}

}
