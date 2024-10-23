package extra;

/**
 * Decorator class extends the Component class
 * and has a Component object to be decorated
 *
 * @author javiergs
 * @version 1.0
 */
public abstract class Decorator extends Component {
	
	protected Component component;
	
	public void setComponent(Component component) {
		this.component = component;
	}
	
	public void draw() {
		if (component != null)
			component.draw();
	}
	
}
