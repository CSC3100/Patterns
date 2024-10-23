package companion;

/**
 * Bag class provides its implementation for draw.
 *
 * @author javiergs
 * @version 1.0
 */
class Bag extends Decorator {
	
	public void draw() {
		super.draw();
		System.out.println("Drawing a bag");
	}
	
}
