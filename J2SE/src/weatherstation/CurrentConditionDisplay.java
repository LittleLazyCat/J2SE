package weatherstation;

public class CurrentConditionDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionDisplay(Subject weatherData) {
		this.setWeatherData(weatherData);
		weatherData.resisterObserver(this);//注册成为观察者
	}
//	display只是把最近的温度和湿度显示出来
	@Override
	public void display() {
		System.out.println("Current conditions: "+temperature+"F degree and "+ humidity +"% humidity");
	}
//	当update（）被调用，我们把温度和湿度保存起来，再调用display（）
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
