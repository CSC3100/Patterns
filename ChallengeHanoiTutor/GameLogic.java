package com.hotsno;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Stack;

/**
 * Class that handles the main logic in the game.
 *
 * @author Andrew Kulakovsky
 * @version 1.0
 */
public class GameLogic implements PropertyChangeListener {
    public static boolean isGameWon() {
        return isWinningState(GameData.getInstance().getHanoiTowersState());
    }

    public static boolean isWinningState(HanoiTowersState hanoiTowersState) {
        int disksOnSecond = hanoiTowersState.getTowerDiskCount(2);
        int disksOnThird = hanoiTowersState.getTowerDiskCount(3);
        int diskCount = hanoiTowersState.getDiskCount();
        return disksOnSecond == diskCount || disksOnThird == diskCount;
    }

    public static HashSet<HanoiTowersState> getValidMoves(HanoiTowersState hanoiTowersState) {
        HashSet<HanoiTowersState> validMoves = new HashSet<>();
        for (int from = 1; from <= 3; from++) {
            Integer fromTop = hanoiTowersState.getTopOfTower(from);
            if (fromTop == null)
                continue;
            for (int to = 1; to <= 3; to++) {
                Integer toTop = hanoiTowersState.getTopOfTower(to);
                if (toTop == null || toTop > fromTop) {
                    HanoiTowersState validMove = new HanoiTowersState(hanoiTowersState, from, to);
                    validMoves.add(validMove);
                }
            }
        }
        return validMoves;
    }

    public static boolean isTopOfTower(Disk disk) {
        for (int i = 1; i <= 3; i++) {
            Integer topOfTower = GameData.getInstance().getHanoiTowersState().getTopOfTower(i);
            if (topOfTower != null && topOfTower == disk.getId()) {
                return true;
            }
        }
        return false;
    }

    public static boolean getTowerForDisk(Disk disk) {
        for (int i = 1; i <= 3; i++)
            if (GameData.getInstance().getHanoiTowersState().getTopOfTower(i) == disk.getId())
                return true;
        return false;
    }

    public static int getTowerForDiskID(int id) {
        for (int i = 1; i <= 3; i++)
            if (GameData.getInstance().getHanoiTowersState().getTower(i).contains(id))
                return i;
        return -1;
    }

    public static int getPositionOnTower(int id) {
        for (int i = 1; i <= 3; i++) {
            Stack<Integer> tower = GameData.getInstance().getHanoiTowersState().getTower(i);
            for (int j = 0; j < tower.size(); j++) {
                if (tower.get(j).equals(id)) {
                    return j + 1;
                }
            }
        }
        return -1;
    }

    public static boolean isValidMove(HanoiTowersState from, HanoiTowersState to) {
        return getValidMoves(from).contains(to);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("gameWon")) {
            GameMain gameMain = GameData.getInstance().getGameMain();
            gameMain.getContentPane().removeAll();
            JLabel winMessage = new JLabel("You win!");
            winMessage.setHorizontalAlignment(SwingConstants.CENTER);
            winMessage.setVerticalAlignment(SwingConstants.CENTER);
            gameMain.add(winMessage, BorderLayout.CENTER);
            gameMain.revalidate();
            gameMain.repaint();
        }
    }
}
