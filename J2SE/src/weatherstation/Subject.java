package weatherstation;

public interface Subject {
	public void resisterObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
