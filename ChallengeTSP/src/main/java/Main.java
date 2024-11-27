package com.hotsno;

import javax.swing.*;

/** JFrame that sets up menu elements and holds the DotsPanel.
 *
 * @author Andrew Kulakovsky
 * @author Michael Wilson
 * @version 1.0
 */
public class Main extends JFrame {
    public static final int INITIAL_WIDTH = 800;
    public static final int INITIAL_HEIGHT = 600;

    public Main() {
        Repository.getInstance().setMain(this);

        createMenuBar();

        DotsPanel dotsPanel = new DotsPanel();
        add(dotsPanel);

        Repository.getInstance().addPropertyChangeListener(dotsPanel);
    }

    private void createMenuBar() {
        MenuController menuController = new MenuController();

        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem("Load");
        JMenuItem clear = new JMenuItem("Exit");
        file.add(clear);
        file.add(load);
        clear.addActionListener(menuController);
        load.addActionListener(menuController);
        menuBar.add(file);

        JMenu run = new JMenu("Run");
        JMenuItem runMenuItem = new JMenuItem("Run...");
        run.add(runMenuItem);
        runMenuItem.addActionListener(menuController);
        menuBar.add(run);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setTitle("");
        main.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        main.setLocationRelativeTo(null);
        main.setResizable(false);
        main.setVisible(true);
    }
}