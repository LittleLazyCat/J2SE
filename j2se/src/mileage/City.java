package mileage;

import java.util.HashMap;
import java.util.Map;

public class City {
	private String cityName;
	private Map<String,Integer> cityDis = new HashMap<String,Integer>();
	public City(String cityName)
	{
		this.cityName = cityName;
	}
	public void addDest(String dest,int mileage)
	{
		cityDis.put(dest, mileage);
	}
	public int getMileage(String dest)
	{
		if(cityDis.containsKey(dest))
		{
			return cityDis.get(dest);
		}
		return -1;
	}
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
