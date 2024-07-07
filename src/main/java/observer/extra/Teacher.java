package observer.extra;

import java.beans.PropertyChangeSupport;

/**
 * Teacher wants to be an observable.
 *
 * @author javiergs
 * @version 1.0
 */
public class Teacher extends PropertyChangeSupport {
	
	private int[] grades = new int[5];
	
	public Teacher() {
		super(null);
	}
	
	public void grade() {
		for (int i = 0; i < grades.length; i++)
			grades[i] = (int) (Math.random() * 100);
		firePropertyChange("grades", null, grades);
		// property, oldValue, newValue
	}
	
	public int getGrade(int index) {
		return grades[index];
	}
	
}
