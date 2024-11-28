package com.hotsno;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

/**
 * Class that represents a certain state of the towers.
 *
 * @author Andrew Kulakovsky
 * @version 1.0
 */
public class HanoiTowersState {
    private final ArrayList<Stack<Integer>> towers;
    private final int diskCount;

    public HanoiTowersState(int diskCount) {
        towers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            towers.add(new Stack<>());
        }
        for (int i = diskCount; i > 0; i--) {
            towers.getFirst().add(i);
        }
        this.diskCount = diskCount;
    }

    public HanoiTowersState(HanoiTowersState from, int moveFrom, int moveTo) {
        towers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < from.towers.get(i).size(); j++) {
                stack.push(from.towers.get(i).get(j));
            }
            towers.add(stack);
        }
        this.diskCount = from.diskCount;
        move(moveFrom, moveTo);
    }

    private void move(int from, int to) {
        if (Integer.min(from, to) < 1 || Integer.max(from, to) > 3) {
            throw new IllegalArgumentException("Move out of bounds");
        } else if (towers.get(from - 1).isEmpty()) {
            throw new IllegalArgumentException("No disks on rod: " + from);
        }
        towers.get(to - 1).add(towers.get(from - 1).pop());
    }

    public Integer getTopOfTower(int tower) {
        if (this.towers.get(tower - 1).isEmpty()) {
            return null;
        }
        return this.towers.get(tower - 1).peek();
    }

    public Stack<Integer> getTower(int tower) {
        return this.towers.get(tower - 1);
    }

    public int getTowerDiskCount(int tower) {
        if (tower < 1 || tower > 3) {
            throw new IllegalArgumentException("Tower out of bounds");
        }
        return towers.get(tower - 1).size();
    }

    public int getDiskCount() {
        return diskCount;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < towers.size(); i++) {
            s.append("[");
            s.append(getTowerString(i));
            s.append("] ");
        }
        return s.toString();
    }

    private String getTowerString(int tower) {
        StringBuilder s = new StringBuilder();
        s.append(" ");
        for (int i = 0; i < towers.get(tower).size(); i++) {
            s.append(towers.get(tower).get(i).toString());
            s.append(" ");
        }
        return s.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(toString());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null || getClass() != object.getClass()) {
            return false;
        }
        return toString().equals(object.toString());
    }
}
