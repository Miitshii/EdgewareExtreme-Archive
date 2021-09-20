package io.github.miitshii.edgewareextreme.config;

import javax.swing.*;

public class ConfigWindowScroller extends JScrollPane {

    private ConfigWindowContent parent;

    public ConfigWindowScroller(ConfigWindowContent parent) {
        this.parent = parent;

        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

}
