package companion;

/**
 * Box class provides its implementation for draw.
 *
 * @author javiergs
 * @version 1.0
 */
class Box extends Decorator {
	
	public void draw() {
		super.draw();
		System.out.println("Drawing a box");
	}
	
}
