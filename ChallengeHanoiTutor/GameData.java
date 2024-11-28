package com.hotsno;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Game data for the Towers of Hanoi game.
 * It contains the disks and towers, and recalculate their positions.
 * It extends PropertyChangeSupport to notify observers of changes in the game data.
 *
 * @author Andrew Kulakovsky
 * @version 1.0
 */
public class GameData extends PropertyChangeSupport {
    private static GameData instance;

    private int diskCount;
    private List<Disk> disks;
    private List<Tower> towers;
    private Disk selectedDisk = null;
    private int mouseYOffset = 0;

    private HanoiTowersState hanoiTowersState;
    private HashMap<HanoiTowersState, HanoiTowersState> recommendations;
    private GameMain gameMain;
    private TowerPanel towerPanel;

    public static class Builder {
        private final GameData gameData;

        public Builder() {
            gameData = new GameData();
        }

        public Builder withGameMain(GameMain gameMain) {
            gameData.gameMain = gameMain;
            return this;
        }

        public Builder withDiskCount(int diskCount) {
            gameData.diskCount = diskCount;
            return this;
        }

        public Builder withTowerPanel(TowerPanel towerPanel) {
            gameData.towerPanel = towerPanel;
            return this;
        }

        public GameData build() {
            gameData.hanoiTowersState = new HanoiTowersState(gameData.diskCount);
            gameData.recommendations = RecommendationAlgorithm.generateRecommendations(gameData.diskCount);
            for (int i = 0; i < 3; i++) {
                int x = 800 / 4 * (i + 1);
                int y = 300;
                gameData.towers.add(new Tower(x, y));
            }
            for (int id = 1; id <= gameData.diskCount; id++) {
                gameData.disks.add(new Disk(id));
            }
            gameData.addPropertyChangeListener(gameData.towerPanel);
            gameData.addPropertyChangeListener(new GameLogic());
            return gameData;
        }
    }

    private GameData() {
        super(new Object());
        towers = new ArrayList<>();
        disks = new ArrayList<>();
    }

    public static GameData getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Game data not initialized");
        }
        return instance;
    }

    public static void setInstance(GameData instance) {
        GameData.instance = instance;
    }

    public List<Disk> getDisks() {
        return disks;
    }

    public Disk getSelectedDisk() {
        return selectedDisk;
    }

    public HanoiTowersState getHanoiTowersState() {
        return hanoiTowersState;
    }

    public void setHanoiTowersState(HanoiTowersState hanoiTowersState) {
        this.hanoiTowersState = hanoiTowersState;
        if (GameLogic.isGameWon()) {
            firePropertyChange("gameWon", false, true);
        }
    }

    public void setSelectedDisk(Disk selectedDisk) {
        this.selectedDisk = selectedDisk;
    }

    public int getMouseXOffset() {
        return mouseXOffset;
    }

    public void setMouseXOffset(int mouseXOffset) {
        this.mouseXOffset = mouseXOffset;
    }

    private int mouseXOffset = 0;

    public int getMouseYOffset() {
        return mouseYOffset;
    }

    public void setMouseYOffset(int mouseYOffset) {
        this.mouseYOffset = mouseYOffset;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public HanoiTowersState getRecommendation() {
        return recommendations.get(hanoiTowersState);
    }

    public void repaint() {
        firePropertyChange("repaint", null, null);
    }

    public GameMain getGameMain() {
        return gameMain;
    }

    public TowerPanel getTowerPanel() {
        return towerPanel;
    }
}
