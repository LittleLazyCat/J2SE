package mileage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in =new Scanner(System.in);
		CityHelper cp = new CityHelper();
		String cityDetail =in.nextLine();
		cp.addCity(cityDetail);
		String mileage;
		String cName;
		for(int i=0;i<cp.getCityNum();i++)
		{
			
			mileage = in.nextLine();
			cName = cp.getCityArray(cityDetail)[i];
			cp.addDest(cName, cityDetail, mileage);
		}
		//String lastLine = in.nextLine();
		System.out.println(cp.getMileage(in.next(),in.next()));
		in.close();
	}

}
