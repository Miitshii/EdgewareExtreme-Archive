package io.github.miitshii.edgewareextreme;

import com.formdev.flatlaf.FlatLightLaf;
import io.github.miitshii.edgewareextreme.configUI.ConfigWindow;
import io.github.miitshii.edgewareextreme.events.DefaultTimeline;
import io.github.miitshii.edgewareextreme.media.MediaManager;
import io.github.miitshii.edgewareextreme.settings.SettingsManager;
import io.github.miitshii.edgewareextreme.settings.SettingsModel;
import lombok.Getter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EdgewareExtreme {

    public static EdgewareExtreme INSTANCE;
    public static EdgewareExtreme $;

    @Getter
    private SettingsManager settingsManager;
    public SettingsModel getSettingsModel() {
        return settingsManager.getModel();
    }
    @Getter
    private ConfigWindow configWindow;
    @Getter
    private PanicButtonListener panicButtonListener;
    @Getter
    private MediaManager mediaManager;
    @Getter
    private List<IPanicPerformedListener> panicPerformedListeners = new ArrayList<>();
    @Getter
    private DefaultTimeline defaultTimeline;

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

        settingsManager = new SettingsManager();
        configWindow = new ConfigWindow();
        mediaManager = new MediaManager();
        panicButtonListener = new PanicButtonListener();
        defaultTimeline = new DefaultTimeline();
    }

    public void panic() {
        System.out.println("PANIC");
        panicPerformedListeners.forEach(panicButtonListener -> panicButtonListener.panicPerformed());
    }

    public void quit() {
        System.exit(0);
    }

}
