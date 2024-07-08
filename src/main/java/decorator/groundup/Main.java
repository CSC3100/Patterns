package decorator.groundup;

/**
 * Main class to test the Decorator pattern
 *
 * @author javiergs
 * @version 1.0
 */
class Main {
	
	public static void main(String args[]) {
		ConcreteComponent component = new ConcreteComponent();
		ConcreteDecoratorOne decoratorOne = new ConcreteDecoratorOne();
		ConcreteDecoratorTwo decoratorTwo = new ConcreteDecoratorTwo();
		// assemble the decorators
		decoratorOne.setComponent(component);
		decoratorTwo.setComponent(decoratorOne);
		// trigger the operation
		decoratorTwo.operation();
	}
	
}