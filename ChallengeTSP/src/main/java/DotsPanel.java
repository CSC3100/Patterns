package com.hotsno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/** JPanel that displays the points stored in the Repository.
 * Listens for updates from the Repository.
 *
 * @author Andrew Kulakovsky
 * @author Michael Wilson
 * @version 1.0
 */
public class DotsPanel extends JPanel implements PropertyChangeListener {
    public DotsPanel() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Repository.getInstance().setPanelHeight(getHeight());
                Repository.getInstance().setPanelWidth(getWidth());
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Point> points = Repository.getInstance().getPoints();
        List<Point> fivePoints = Repository.getInstance().getFivePoints();
        boolean loadStatistics = Repository.getInstance().getLoadStatistics();

        g.setColor(Color.BLACK);
        for (Point point : points) {
            g.fillOval((int) point.getX(), (int) point.getY(), 2, 2);
        }
        if (loadStatistics && fivePoints.size() == 5) {
            Point closestMiddle = fivePoints.get(4);

            g.setColor(Color.BLUE);
            for (int i = 0; i < 4; i++) {
                Point point = fivePoints.get(i);
                g.fillOval(point.x, point.y, 15, 15);
                g.drawLine(point.x, point.y, closestMiddle.x, closestMiddle.y);
            }
            g.fillOval(closestMiddle.x, closestMiddle.y, 15, 15);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("repaint")) {
            repaint();
        }
    }
}
