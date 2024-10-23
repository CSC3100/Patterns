package template;

/**
 * Concrete Decorator class that extends the Decorator class
 *
 * @author javiergs
 * @version 1.0
 */
class ConcreteDecoratorOne extends Decorator {
	
	public void operation() {
		super.operation();
		System.out.println("Operation executed from ConcreteDecorator One");
	}
	
}