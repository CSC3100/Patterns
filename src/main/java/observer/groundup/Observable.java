package observer.groundup;

import java.util.ArrayList;

/**
 * Observable class for the Observer pattern.
 *
 * @author javiergs
 * @version 1.0
 */
public abstract class Observable {
	
	private ArrayList<Observer> observers = new ArrayList<>();
	private boolean changed = false;
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void notifyObservers() {
		if (changed) {
			for (Observer o : observers) {
				o.update(this);
			}
			changed = false;
		}
	}
	
	protected void setChanged() {
		changed = true;
	}
	
}
