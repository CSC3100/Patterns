package com.hotsno;

import javax.swing.*;
import java.awt.*;

/**
 * The main class for the Towers of Hanoi game. It extends JFrame and adds UI panels to it.
 * It also initializes the game's data and controller.
 *
 * @author Andrew Kulakovsky
 * @version 1.0
 */
public class GameMain extends JFrame {
    public GameMain() {
        setSize(800, 400);
        TowerPanel towerPanel = new TowerPanel();
        GameController controller = new GameController();
        GameData gameData = new GameData.Builder()
                .withGameMain(this)
                .withDiskCount(4)
                .withTowerPanel(towerPanel)
                .build();
        GameData.setInstance(gameData);

        ControlPanel controlPanel = new ControlPanel();
        add(towerPanel);
        add(controlPanel, BorderLayout.SOUTH);

        towerPanel.addMouseListener(controller);
        towerPanel.addMouseMotionListener(controller);
        towerPanel.addComponentListener(controller);
    }

    public static void main(String[] args) {
        GameMain main = new GameMain();
        main.setSize(800, 400);
        main.setTitle("Towers of Hanoi");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
        main.setResizable(false);
    }
}
