package observer.extra;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Students want to be an observer of the Teacher.
 *
 * @author javiergs
 * @version 1.0
 */
public class Student implements PropertyChangeListener {
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		int myGrade = ((Teacher) evt.getSource()).getGrade(0);
		System.out.println("My grade is: " + myGrade);
	}
	
}
