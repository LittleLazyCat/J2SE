package mileageV2;

import java.util.HashMap;
import java.util.Map;

public class City {
	private String cityName;	//������
	private Map<String,String> cityDis = new HashMap<String,String>();	//��Ŀ�ĵ��Լ����
	public City(String cityName)
	{
		this.cityName = cityName;
	}
	public void addDest(String dest,String mileage)
	{
		cityDis.put(dest, mileage);
	}
	//��õ�ĳ�ص����
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
