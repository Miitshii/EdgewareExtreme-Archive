package io.github.miitshii.edgewareextreme.components;

import java.awt.*;

public class BasicGBC extends GridBagConstraints {

    public BasicGBC(int gridx, int gridy,
                    int gridwidth, int gridheight) {
        super();
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

}
