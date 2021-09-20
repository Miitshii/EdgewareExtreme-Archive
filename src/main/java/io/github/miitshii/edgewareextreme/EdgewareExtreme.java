package io.github.miitshii.edgewareextreme;

import com.formdev.flatlaf.FlatLightLaf;
import io.github.miitshii.edgewareextreme.config.ConfigWindow;

import javax.swing.*;

public class EdgewareExtreme {

    EdgewareExtreme() {
        try {
            FlatLightLaf.setup();
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new ConfigWindow(this);
    }

    public void panic() {
        System.exit(0);
    }

}
