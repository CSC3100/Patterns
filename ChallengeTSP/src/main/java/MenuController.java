package com.hotsno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/** Listens for menu actions and responds appropriately.
 *
 * @author Andrew Kulakovsky
 * @author Michael Wilson
 * @version 1.0
 */
public class MenuController implements ActionListener {
    private final LoadDataStrategy loadDataStrategy = new LoadDataFromFileStrategy();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Load")) {
            load();
        } else if (e.getActionCommand().equals("Exit")) {
            Repository.getInstance().getMain().dispose();
        } else if (e.getActionCommand().equals("Run...")) {
            Repository.getInstance().setLoadStatistics(true);
        }
    }

    private void load() {
        // file chooser to select directory and name
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to load");
        int userSelection = fileChooser.showOpenDialog(Repository.getInstance().getMain());
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            return;
        }
        // load
        String path = fileChooser.getSelectedFile().getAbsolutePath();
        try {
            loadDataStrategy.loadData(path);
        } catch (IOException e) {
            System.out.println("Encountered an error when reading data.");
            e.printStackTrace();
        }
    }
}
