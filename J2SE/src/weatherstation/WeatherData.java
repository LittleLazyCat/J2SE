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

//	��ע��۲���ʱ������ֻҪ�����ӵ�ArrayList���漴��
	@Override
	public void resisterObserver(Observer o) {
		observers.add(o);
	}
//	ͬ���ģ����۲�����Ҫȡ��ע�ᣬֻҪ��ArrayList��ȥ��
	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i>=0)
		{
			observers.remove(i);
		}
		
	}
//	��Ϊ�۲��߶�ʵ����update����������֪�����֪ͨ����
	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++)
		{
			Observer observer = observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
//	������վ��ø��£�����֪ͨ�۲���
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
