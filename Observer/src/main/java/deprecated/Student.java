package deprecated;

import java.util.Observable;
import java.util.Observer;

/**
 * Students want to be an observer of the Teacher.
 *
 * @author javiergs
 * @version 1.0
 */
public class Student implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		int myGrade = ((Teacher) o).getGrade(0);
		System.out.println("My grade is: " + myGrade);
	}
	
}
