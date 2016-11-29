package mileageV2;

import java.util.HashMap;
import java.util.Map;

public class CityHelper {

	private Map<String, City> mapCity = new HashMap<String, City>();
	private Map<Integer, String> mapNum = new HashMap<Integer, String>();
	static int num = 1;// ���������
	static int mileageNum = 0;// ��¼�ڼ��λ�����


	// �õ�������Ŀ
	public int getCityNum() {

		return num;
	}

	// ���ӳ���
	public void addCity(String cName) {

		City c = new City(cName);
		mapCity.put(cName, c);
		mapNum.put(num, cName);
		num++;
	}

	// ����ĳһ����Ŀ�ĵؼ����
	public void addDest(String mileage) {
		
		int start = mileageNum / num + 1;		//Ŀǰ��¼�����ĸ�����
		int dest = mileageNum %num +1;		//Ŀǰ��¼�����ĸ�Ŀ�ĵ�
		String startCity  = mapNum.get(start);
		City city = mapCity.get(startCity);
		String destCity = mapNum.get(dest);
		city.addDest(destCity, mileage);
		mileageNum++;

	}

	// ���ĳ�ص�ĳ�ص����
	public String getMileage(String city, String dest) {

		return mapCity.get(city).getMileage(dest);
	}
}