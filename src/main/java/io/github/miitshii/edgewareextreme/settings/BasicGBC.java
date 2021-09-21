package io.github.miitshii.edgewareextreme.settings;

import java.awt.*;

public class BasicGBC extends GridBagConstraints {

    public BasicGBC(int gridx, int gridy,
                    int gridwidth, int gridheight,
                    double weightx, double weighty,
                    int fill, int anchor) {
        super();
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
        this.weightx = weightx;
        this.weighty = weighty;
        this.fill = fill;
        this.anchor = anchor;
    }

}
