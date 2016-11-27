package mileageV2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CityHelper cp = new CityHelper();
		Scanner in =new Scanner(System.in);
		String cName = in.next();
		while(true)
		{
			if("###".equals(cName))
			{
				break;
			}
			else
			{
				cp.addCity(cName);
			}
		}
		
		String mileage;
		for(int i =0;i<cp.getCityNum();i++)
		{
			for(int j=0;j>cp.getCityNum();j++)
			{
				mileage = in.nextLine();
				cp.addDest(mileage);
			}
		}
		String city = in.next();
		String dest  = in.next();
		System.out.println(cp.getMileage(city, dest));
		in.close();
		
	}

}
