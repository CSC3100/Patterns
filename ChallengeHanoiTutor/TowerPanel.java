package com.hotsno;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The panel that displays the towers and disks.
 * It overrides paintComponent to draw the towers and disks, and
 * It implements PropertyChangeListener (observer pattern) to listen for changes in the game data.
 *
 * @author Andrew Kulakovsky
 * @version 1.0
 */
public class TowerPanel extends JPanel implements PropertyChangeListener {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        for (Tower tower : GameData.getInstance().getTowers()) {
            tower.draw(g);
        }
        for (Disk disk : GameData.getInstance().getDisks()) {
            disk.draw(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("repaint")) {
            repaint();
        }
    }
}
