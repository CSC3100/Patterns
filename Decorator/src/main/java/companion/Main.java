package companion;

/**
 * Main class to test the Decorator pattern
 *
 * @author javiergs
 * @version 1.0
 */
class Main {
	
	public static void main(String args[]) {
		Ball ball = new Ball();
		Bag bag = new Bag();
		Box box = new Box();
		// assemble the decorators
		bag.setComponent(ball);
		box.setComponent(bag);
		// trigger the operation
		box.draw();
	}
	
}
