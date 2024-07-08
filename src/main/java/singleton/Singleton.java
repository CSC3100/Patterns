package singleton;

/**
 * Example of a class that ensures that only one instance can be created.
 *
 * @author javiergs
 * @version 1.0
 */
class Singleton {
	
	private static Singleton instance;
	
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}
	
}
