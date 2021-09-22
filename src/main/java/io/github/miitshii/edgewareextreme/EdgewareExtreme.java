package io.github.miitshii.edgewareextreme;

import com.formdev.flatlaf.FlatLightLaf;
import io.github.miitshii.edgewareextreme.config.ConfigWindow;

import javax.swing.*;
import java.awt.*;

public class EdgewareExtreme {

    public static EdgewareExtreme INSTANCE;
    public static EdgewareExtreme $;

    private ConfigWindow configWindow;
    private PanicButtonListener panicButtonListener;

    public ConfigWindow getConfigWindow() {
        return configWindow;
    }

    public EdgewareExtreme() {
        if (INSTANCE != null) {
            throw new IllegalStateException();
        }
        INSTANCE = this;
        $ = this;

        try {
            FlatLightLaf.setup();
            UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme");
        } catch (Exception e) {
            e.printStackTrace();
        }

        configWindow = new ConfigWindow();
        panicButtonListener = new PanicButtonListener();
    }

    public void panic() {
        // TODO panic
        System.out.println("PANIC");
    }

    public void quit() {
        System.exit(0);
    }

}
