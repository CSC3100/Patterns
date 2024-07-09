package integrate.plotter;

import javax.swing.*;
import java.awt.*;

/**
 * Main class that creates the GUI and runs the program.
 *
 * @author javiergs
 * @version 1.0
 */
public class Main extends JFrame {
	
	public static void main(String[] args) {
		Main main = new Main();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(400, 600);
		main.setVisible(true);
	}
	
	public Main() {
		Genius genius = new Genius();
		Thread thread = new Thread(genius);
		thread.start();
		// first line
		MarkerSimple chartSimple = new MarkerSimple();
		MarkerDecoratorDot shadow = new MarkerDecoratorDot();
		MarkerDecoratorBar dot = new MarkerDecoratorBar();
		dot.add(chartSimple);
		shadow.add(dot);
		ChartPanel chartPanelOne = new ChartPanel(shadow);
		chartPanelOne.setBackground(new Color(150, 150, 150, 255));
		// second line
		MarkerSimple chartSimpleTwo = new MarkerSimple();
		MarkerDecoratorDot shadowTwo = new MarkerDecoratorDot();
		shadowTwo.add(chartSimpleTwo);
		ChartPanel chartPanelTwo = new ChartPanel(shadowTwo);
		chartPanelTwo.setBackground(new Color(200, 200, 200));
		// third line
		MarkerSimple chartSimpleThree = new MarkerSimple();
		ChartPanel chartPanelThree = new ChartPanel(chartSimpleThree);
		chartPanelThree.setBackground(new Color(250, 250, 250));
		// add observers
		Board.getInstance().addPropertyChangeListener (chartPanelOne);
		Board.getInstance().addPropertyChangeListener (chartPanelTwo);
		Board.getInstance().addPropertyChangeListener (chartPanelThree);
		// set layout
		setLayout(new GridLayout(3, 1));
		add(chartPanelOne);
		add(chartPanelTwo);
		add(chartPanelThree);
	}
	
}
