package observer.deprecated;

/**
 * This class demonstrates the Observer pattern using java.util Observables and Observers.
 *
 * @author javiergs
 * @version 1.0
 */
public class Classroom {

	public static void main(String[] args) {
		Student student = new Student();
		Teacher teacher = new Teacher();
		System.out.println("Classroom created with student and teacher");
		teacher.addObserver(student);
		teacher.grade();
	}
	
}