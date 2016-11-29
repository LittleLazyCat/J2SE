package mileage;

import java.util.HashMap;
import java.util.Map;

public class CityHelper {

	private Map<String, City> map = new HashMap<String, City>();
	// 得到具体有哪些城市
	public String[] getCityArray(String s) {
		String[] detail = s.split("\t");
		String last = detail[detail.length-1];
		last = last.substring(0, last.length()-3);
		detail[detail.length-1] = last.trim();
		return detail;
	}

	// 得到每一行的里程数
	public String[] getMileageArray(String s) {
		String[] detail = s.split("\t");
		return detail;
	}

	// 得到城市数目
	public int getCityNum(String s) {
		String[] detail = s.split("\t");
		return detail.length ;
	}

	// 得到城市数目
	public int getCityNum() {

		return map.size();
	}

	// 增加城市
	public void addCity(String s) {

		CityHelper helper = new CityHelper();
		String cName;
		for (int i = 0; i < helper.getCityNum(s); i++) {
			cName = helper.getCityArray(s)[i];
			City c = new City(cName);
			map.put(cName, c);
		}

	}

	// 增加某一城市目的地及里程
	public void addDest(String cName, String cDetail, String mileage) {
		City city = map.get(cName);
		for (int i = 0; i < this.getCityNum(); i++) {
			city.addDest(this.getCityArray(cDetail)[i], Integer.parseInt(this.getMileageArray(mileage)[i]));
		}

	}

	// 获得某地到某地的里程
	public int getMileage(String city,String dest) {
//		String[] array = line.split(" ");
//		String city = array[0];
//		String dest = array[array.length-1];
		
		
		return map.get(city).getMileage(dest);
	}
}
