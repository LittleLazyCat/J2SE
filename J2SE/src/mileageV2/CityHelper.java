package mileageV2;

import java.util.HashMap;
import java.util.Map;

public class CityHelper {

	private Map<String, City> mapCity = new HashMap<String, City>();
	private Map<Integer, String> mapNum = new HashMap<Integer, String>();
	static int num = 1;// 存城市数量
	static int mileageNum = 0;// 记录第几次获得里程


	// 得到城市数目
	public int getCityNum() {

		return num;
	}

	// 增加城市
	public void addCity(String cName) {

		City c = new City(cName);
		mapCity.put(cName, c);
		mapNum.put(num, cName);
		num++;
	}

	// 增加某一城市目的地及里程
	public void addDest(String mileage) {
		
		int start = mileageNum / num + 1;		//目前记录的是哪个城市
		int dest = mileageNum %num +1;		//目前记录的是哪个目的地
		String startCity  = mapNum.get(start);
		City city = mapCity.get(startCity);
		String destCity = mapNum.get(dest);
		city.addDest(destCity, mileage);
		mileageNum++;

	}

	// 获得某地到某地的里程
	public String getMileage(String city, String dest) {

		return mapCity.get(city).getMileage(dest);
	}
}
