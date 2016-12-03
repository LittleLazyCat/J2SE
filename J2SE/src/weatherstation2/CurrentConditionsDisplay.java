package weatherstation2;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	Observable observable;
//	���ڹ�������Ҫһ��Observable������������CurrentConditionsDisplay����Ǽǳ�Ϊ�۲���
	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions: "+temperature+"F degree and "+ humidity +"% humidity");
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData)
		{
			WeatherData wd = (WeatherData)o;
			this.temperature = wd.getTemperature();
			this.humidity = wd.getHumidity();
			display();
		}
	}

}
