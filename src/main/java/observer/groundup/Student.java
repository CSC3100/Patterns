package observer.groundup;

/**
 * Students want to be an observer of the Teacher.
 *
 * @author javiergs
 * @version 1.0
 */
public class Student implements Observer {
	
	@Override
	public void update(Observable from) {
		int myGrade = ((Teacher) from).getGrade(0);
		System.out.println("My grade is: " + myGrade);
	}
	
}

