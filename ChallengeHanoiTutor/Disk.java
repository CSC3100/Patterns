package com.hotsno;

import java.awt.*;
import java.util.List;

/**
 * A disk in the Towers of Hanoi game.
 * It can be drawn, selected, deselected, and moved to a tower, and compared to other disks based on width.
 *
 * @author Andrew Kulakovsky
 * @version 1.0
 */
public class Disk {
    private static final java.util.List<Color> COLORS = List.of(new Color(0x083D77),
            new Color(0xEBEBD3),
            new Color(0xDA4167),
            new Color(0xF4D35E),
            new Color(0xF78764));

    private final Color color;
    private final int id;
    private boolean dragged = false;
    private int draggedX = 0;
    private int draggedY = 0;

    public Disk(int id) {
        this.id = id;
        this.color = COLORS.get(id - 1 % COLORS.size());
    }

    public int getTower() {
        return GameLogic.getTowerForDiskID(id);
    }

    public int getX() {
        if (dragged)
            return draggedX;
        return GameData.getInstance().getTowers().get(getTower() - 1).getX() - getWidth() / 2;
    }

    public int getY() {
        if (dragged)
            return draggedY;
        int position = GameLogic.getPositionOnTower(id);
        return GameData.getInstance().getTowers().get(getTower() - 1).getY() - position * 20;
    }

    public int getWidth() {
        return id * 20;
    }

    public int getId() {
        return id;
    }

    public void setDragged(boolean dragged) {
        this.dragged = dragged;
    }

    public void setDraggedX(int draggedX) {
        this.draggedX = draggedX;
    }

    public void setDraggedY(int draggedY) {
        this.draggedY = draggedY;
    }

    public void draw(Graphics g) {
        if (GameData.getInstance().getSelectedDisk() == this) {
            g.setColor(Color.YELLOW);
            g.fillRect(getX(), getY(), getWidth(), 20);
            g.setColor(Color.RED);
            g.drawRect(getX(), getY(), getWidth(), 20);
        } else {
            g.setColor(color);
            g.fillRect(getX(), getY(), getWidth(), 20);
        }
    }

    public boolean contains(int x, int y) {
        return x >= getX() && x <= getX() + getWidth() && y >= getY() && y <= getY() + 20;
    }
}
