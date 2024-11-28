package com.hotsno;

import java.awt.event.*;
import java.beans.PropertyChangeSupport;

/**
 * The controller for the Towers of Hanoi game.
 * It implements MouseListener, MouseMotionListener, and ComponentListener to handle mouse events and resizing.
 * It moves disks when dragged and dropped, and repaints the game when resized.
 *
 * @author Andrew Kulakovsky
 * @version 1.0
 */
public class GameController implements MouseListener, MouseMotionListener, ComponentListener {

    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < GameData.getInstance().getDisks().size(); i++) {
            Disk disk = GameData.getInstance().getDisks().get(i);
            if (disk.contains(e.getX(), e.getY()) && GameLogic.isTopOfTower(disk)) {
                GameData.getInstance().setSelectedDisk(disk);
                GameData.getInstance().setMouseXOffset(e.getX() - disk.getX());
                GameData.getInstance().setMouseYOffset(e.getY() - disk.getY());
                disk.setDragged(true);
                break;
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (GameData.getInstance().getSelectedDisk() != null) {
            int i = 1;
            for (Tower tower : GameData.getInstance().getTowers()) {
                tower.setSelected(false);
                Disk disk = GameData.getInstance().getSelectedDisk();
                if (tower.contains(e.getX(), e.getY())) {
                    HanoiTowersState oldState = GameData.getInstance().getHanoiTowersState();
                    HanoiTowersState newState = new HanoiTowersState(oldState, disk.getTower(), i);
                    if (!GameLogic.isValidMove(oldState, newState))
                        continue;

                    GameData.getInstance().setHanoiTowersState(newState);
                    disk.setDragged(false);
                }
                disk.setDragged(false);
                i++;
            }
            GameData.getInstance().setSelectedDisk(null);
            GameData.getInstance().repaint();
        }
    }

    public void mouseDragged(MouseEvent e) {
        if (GameData.getInstance().getSelectedDisk() != null) {
            for (Tower tower : GameData.getInstance().getTowers()) {
                tower.setSelected(tower.contains(e.getX(), e.getY()));
            }
            GameData.getInstance().getSelectedDisk().setDraggedX(e.getX() - GameData.getInstance().getMouseXOffset());
            GameData.getInstance().getSelectedDisk().setDraggedY(e.getY() - GameData.getInstance().getMouseYOffset());
            GameData.getInstance().repaint();
        }
    }

    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
}
