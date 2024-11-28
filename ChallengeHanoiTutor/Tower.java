package com.hotsno;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a tower in the Towers of Hanoi game.
 * It can be drawn, checked if it contains a point, and drop a disk on the tower.
 *
 * @author Andrew Kulakovsky
 * @version 1.0
 */
public class Tower {
    private static final int TOWER_WIDTH = 10;
    private static final int TOWER_HEIGHT = 100;

    private final int x;
    private final int y;
    private boolean selected;

    public Tower(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        if (!selected) {
            drawBody(g, Color.BLACK);
        } else {
            drawBody(g, Color.RED);
            drawOutline(g, Color.YELLOW);
        }
    }

    private void drawBody(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(x - TOWER_WIDTH / 2, y - TOWER_HEIGHT, TOWER_WIDTH, TOWER_HEIGHT);
    }

    private void drawOutline(Graphics g, Color color) {
        g.setColor(color);
        g.drawRect(x - TOWER_WIDTH / 2, y - TOWER_HEIGHT, TOWER_WIDTH, TOWER_HEIGHT);
    }

    public boolean contains(int x, int y) {
        return Math.abs(x - this.x) <= 5 && Math.abs(y - this.y) <= 100;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
