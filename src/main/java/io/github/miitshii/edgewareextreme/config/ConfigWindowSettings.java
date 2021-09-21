package io.github.miitshii.edgewareextreme.config;

import io.github.miitshii.edgewareextreme.components.SettingsSlider;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ConfigWindowSettings extends JPanel {


    public ConfigWindowSettings() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridLayout(0, 1, 10, 10));

        setupAnnoyanceSettings();
    }

    private void setupAnnoyanceSettings() {
        JPanel annoyanceSettings = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        annoyanceSettings.setLayout(gbl);
        annoyanceSettings.setBorder(new TitledBorder(BorderFactory.createLineBorder(UIManager.getColor("Borders.color")), "Annoyance"));

        annoyanceSettings.add(new SettingsSlider("Time Delay (ms)", 10, 6000, gbl, 0));

        add(annoyanceSettings);
    }

}
