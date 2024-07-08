package decorator.groundup;

/**
 * Concrete Component class provides an implementation for operation.
 *
 * @author javiergs
 * @version 1.0
 */
public class ConcreteComponent extends Component {
	
	@Override
	public void operation() {
		System.out.println("Operation executed from ConcreteComponent");
	}
	
}

