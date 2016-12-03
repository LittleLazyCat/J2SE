package weatherstation;

public class CurrentConditionDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionDisplay(Subject weatherData) {
		this.setWeatherData(weatherData);
		weatherData.resisterObserver(this);//ע���Ϊ�۲���
	}
//	displayֻ�ǰ�������¶Ⱥ�ʪ����ʾ����
	@Override
	public void display() {
		System.out.println("Current conditions: "+temperature+"F degree and "+ humidity +"% humidity");
	}
//	��update���������ã����ǰ��¶Ⱥ�ʪ�ȱ����������ٵ���display����
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}

	public Subject getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(Subject weatherData) {
		this.weatherData = weatherData;
	}


}
