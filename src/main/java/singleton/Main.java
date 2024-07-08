package singleton;

/**
 * Main class that tests the Singleton class.
 *
 * @author javiergs
 * @version 1.0
 */
class Main {
	
	public static void main(String[] a) {
		// Constructor cannot use new
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		// Test for same instance
		if (s1 == s2) {
			System.out.println("Both instances are the same");
		}
	}
	
}
