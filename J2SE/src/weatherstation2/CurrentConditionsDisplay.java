package weatherstation2;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	Observable observable;
//	现在构造器需要一个Observable当参数，并将CurrentConditionsDisplay对象登记成为观察者
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
