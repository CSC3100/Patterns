package observer.deprecated;

import java.util.Observable;

/**
 * Teacher wants to be an observable.
 *
 * @author javiergs
 * @version 1.0
 */
public class Teacher extends Observable {
	
	private int[] grades = new int[5];
	
	public void grade() {
		for (int i = 0; i < grades.length; i++)
			grades[i] = (int) (Math.random() * 100);
		setChanged();
		notifyObservers();
	}
	
	public int getGrade(int index) {
		return grades[index];
	}
	
}
