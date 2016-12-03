package weatherstation2;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData wd = new WeatherData();
		CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(wd);
		wd.setMeasurements(12, 20, 12.7f);
		 
	}

}
