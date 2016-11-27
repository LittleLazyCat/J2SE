package mileageV2;

import java.util.HashMap;
import java.util.Map;

public class City {
	private String cityName;	//城市名
	private Map<String,String> cityDis = new HashMap<String,String>();	//存目的地以及里程
	public City(String cityName)
	{
		this.cityName = cityName;
	}
	public void addDest(String dest,String mileage)
	{
		cityDis.put(dest, mileage);
	}
	//获得到某地的里程
	public String getMileage(String dest)
	{
		if(cityDis.containsKey(dest))
		{
			return cityDis.get(dest);
		}
		return "-1";
	}
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
