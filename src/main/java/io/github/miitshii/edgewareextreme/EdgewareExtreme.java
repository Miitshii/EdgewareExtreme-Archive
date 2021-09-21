package io.github.miitshii.edgewareextreme;

import com.formdev.flatlaf.FlatLightLaf;
import io.github.miitshii.edgewareextreme.config.ConfigWindow;

import javax.swing.*;

public class EdgewareExtreme {

    public static EdgewareExtreme INSTANCE;
    public static EdgewareExtreme $;

    private ConfigWindow configWindow;

    public EdgewareExtreme() {
        INSTANCE = this;
        $ = this;

        try {
            FlatLightLaf.setup();
            UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme");
        } catch (Exception e) {
            e.printStackTrace();
        }

        configWindow = new ConfigWindow();
    }

    public void panic() {
        System.exit(0);
    }

}
