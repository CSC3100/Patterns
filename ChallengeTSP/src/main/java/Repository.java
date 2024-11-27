package com.hotsno;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Singleton class to store data.
 * Notifies listeners when data is changed.
 *
 * @author Andrew Kulakovsky
 * @author Michael Wilson
 * @version 1.0
 */
public class Repository extends PropertyChangeSupport {
    private static Repository instance;
    private Main main;

    private ArrayList<Point> points;
    private List<Point> fivePoints;
    private int panelHeight = 0;
    private int panelWidth = 0;

    private boolean loadStatistics = false;

    public Repository() {
        super(new Object());

        points = new ArrayList<>();
        fivePoints = Collections.emptyList();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Main getMain() {
        return this.main;
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
        firePropertyChange("repaint", null, 1);
    }

    public List<Point> getFivePoints() {
        return fivePoints;
    }

    public void setFivePoints(List<Point> fivePoints) {
        this.fivePoints = fivePoints;
        firePropertyChange("repaint", null, 1);
    }

    public int getPanelHeight() {
        return this.panelHeight;
    }

    public void setPanelHeight(int height) {
        this.panelHeight = height;
    }

    public int getPanelWidth() {
        return this.panelWidth;
    }

    public void setPanelWidth(int width) {
        this.panelWidth = width;
    }

    public boolean getLoadStatistics() {
        return loadStatistics;
    }

    public void setLoadStatistics(boolean loadStatistics) {
        this.loadStatistics = loadStatistics;
        firePropertyChange("repaint", null, 1);
    }
}
