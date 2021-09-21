package io.github.miitshii.edgewareextreme.config;

import io.github.miitshii.edgewareextreme.settings.GsonSettings;
import io.github.miitshii.edgewareextreme.settings.SettingsSlider;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ConfigWindowSettings extends JPanel {

    public ConfigWindowSettings() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridLayout(0, 1, 10, 10));

        new GsonSettings();
        setupAnnoyanceSettings();
    }

    private void setupAnnoyanceSettings() {
        JPanel annoyanceSettings = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        annoyanceSettings.setLayout(gbl);
        annoyanceSettings.setBorder(new TitledBorder(BorderFactory.createLineBorder(UIManager.getColor("Borders.color")), "Annoyance"));

        new SettingsSlider(GsonSettings.M::getAnnoyanceDelay, GsonSettings.M::setAnnoyanceDelay, "Time Delay (ms)", 10, 60000, annoyanceSettings, gbl, 0);
        new SettingsSlider(GsonSettings.M::getAnnoyanceDelay, GsonSettings.M::setAnnoyanceDelay, "Time Daaelay (ms)", 10, 60000, annoyanceSettings, gbl, 1);
        new SettingsSlider(GsonSettings.M::getAnnoyanceDelay, GsonSettings.M::setAnnoyanceDelay, "Time Daaaaaaaaaaaaaaaelay (ms)", 10, 60000, annoyanceSettings, gbl, 2);

        add(annoyanceSettings);
    }

}
