package weatherstation;

import java.util.ArrayList;

public class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

//	当注册观察者时，我们只要把它加到ArrayList后面即可
	@Override
	public void resisterObserver(Observer o) {
		observers.add(o);
	}
//	同样的，当观察者想要取消注册，只要从ArrayList中去除
	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i>=0)
		{
			observers.remove(i);
		}
		
	}
//	因为观察者都实现了update，所以我们知道如何通知他们
	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++)
		{
			Observer observer = observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
//	当气象站获得更新，我们通知观察者
	public void measurementsChanged(){
		notifyObservers();
	}
	public void setMeasurements(float temp,float humidity,float pressure){
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}
