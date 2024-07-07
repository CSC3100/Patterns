package observer.extra;

import javax.swing.*;

/**
 * This class demonstrates the Observer pattern using PropertyChangeListeners.
 * And GUI components.
 *
 * @author javiergs
 * @version 1.0
 */
public class Classroom extends JFrame {

	public static void main(String[] args) {
		Student student = new Student();
		Teacher teacher = new Teacher();
		System.out.println("Classroom created with student and teacher");
		teacher.addPropertyChangeListener(student);
		teacher.grade();
	}
	
}
