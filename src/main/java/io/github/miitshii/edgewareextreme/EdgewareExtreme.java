package io.github.miitshii.edgewareextreme;

import com.formdev.flatlaf.FlatLightLaf;
import io.github.miitshii.edgewareextreme.config.ConfigWindow;
import io.github.miitshii.edgewareextreme.settings.GsonSettings;
import io.github.miitshii.edgewareextreme.settings.GsonSettingsModel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class EdgewareExtreme {

    public static EdgewareExtreme INSTANCE;
    public static EdgewareExtreme $;

    @Getter
    private GsonSettings gsonSettings;
    public GsonSettingsModel getSettingsModel() {
        return gsonSettings.getModel();
    }
    @Getter
    private ConfigWindow configWindow;
    @Getter
    private PanicButtonListener panicButtonListener;

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

        gsonSettings = new GsonSettings();
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
