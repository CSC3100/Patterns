package com.hotsno;

import javax.swing.*;

/**
 * The panel that the disk slider and hint button.
 *
 * @author Andrew Kulakovsky
 * @version 1.0
 */
public class ControlPanel extends JPanel {
    public ControlPanel() {
        add(getSliderLabel());
        add(getSlider());
        add(getHintButton());
    }

    private JLabel getSliderLabel() {
        return new JLabel("Number of Disks:", SwingConstants.CENTER);
    }

    private JSlider getSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 5, 4);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.addChangeListener(e -> {
            GameData newGameData = new GameData.Builder()
                    .withGameMain(GameData.getInstance().getGameMain())
                    .withTowerPanel(GameData.getInstance().getTowerPanel())
                    .withDiskCount(slider.getValue())
                    .build();
            GameData.setInstance(newGameData);
            GameData.getInstance().repaint();
        });
        return slider;
    }

    private JButton getHintButton() {
        JButton hintButton = new JButton("Hint");
        hintButton.addActionListener(e -> {
            HanoiTowersState recommendation = GameData.getInstance().getRecommendation();
            GameData.getInstance().setHanoiTowersState(recommendation);
            GameData.getInstance().repaint();
        });
        return hintButton;
    }
}