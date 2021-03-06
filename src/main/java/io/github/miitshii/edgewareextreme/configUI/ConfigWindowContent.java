package io.github.miitshii.edgewareextreme.configUI;

import javax.swing.*;

public class ConfigWindowContent extends JPanel {

    private SpringLayout layout;
    private ConfigWindowQuickSetup quickSetup;
    private ConfigWindowSettings settings;
    private ConfigWindowAbout about;
    private JTabbedPane tabbedPane;

    public ConfigWindowContent() {
        setLayout(layout = new SpringLayout());
        add(tabbedPane = new JTabbedPane());
        tabbedPane.addTab("QUICK SETUP", quickSetup = new ConfigWindowQuickSetup());
        tabbedPane.addTab("SETTINGS", settings = new ConfigWindowSettings());
        tabbedPane.addTab("ABOUT", about = new ConfigWindowAbout());
        layout.putConstraint(SpringLayout.NORTH, this, 0, SpringLayout.NORTH, tabbedPane);
        layout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST, tabbedPane);
        layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, tabbedPane);
        layout.putConstraint(SpringLayout.WEST, this, 0, SpringLayout.WEST, tabbedPane);
    }

}
