package io.github.miitshii.edgewareextreme.config;

import javax.swing.*;

public class ConfigWindowContent extends JPanel {

    private ConfigWindow parent;
    private SpringLayout layout;
    private ConfigWindowScroller scroller;

    public ConfigWindowContent(ConfigWindow parent) {
        this.parent = parent;

        setLayout(layout = new SpringLayout());
        add(scroller = new ConfigWindowScroller(this));
        layout.putConstraint(SpringLayout.NORTH, this, 0, SpringLayout.NORTH, scroller);
        layout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST, scroller);
        layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, scroller);
        layout.putConstraint(SpringLayout.WEST, this, 0, SpringLayout.WEST, scroller);
    }

}
