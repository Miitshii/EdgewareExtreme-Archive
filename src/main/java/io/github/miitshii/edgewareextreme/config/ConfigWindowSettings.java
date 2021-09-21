package io.github.miitshii.edgewareextreme.config;

import io.github.miitshii.edgewareextreme.settings.BasicGBC;
import io.github.miitshii.edgewareextreme.settings.GsonSettings;
import io.github.miitshii.edgewareextreme.settings.SettingsSlider;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ConfigWindowSettings extends JPanel {

    private GridBagLayout layout;

    public ConfigWindowSettings() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(layout = new GridBagLayout());

        setupAnnoyanceSettings();
    }

    private void setupAnnoyanceSettings() {
        JPanel annoyanceSettings = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        annoyanceSettings.setLayout(gbl);
        annoyanceSettings.setBorder(new CompoundBorder(new TitledBorder(BorderFactory.createLineBorder(UIManager.getColor("Borders.color")), "Annoyance"), new EmptyBorder(5, 5, 5, 5)));

        new SettingsSlider(GsonSettings.M::getAnnoyanceDelay, GsonSettings.M::setAnnoyanceDelay, "Time Delay (ms)", 10, 60000, annoyanceSettings, gbl, 0);

        add(annoyanceSettings);
        layout.setConstraints(annoyanceSettings, new BasicGBC(0, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH));
    }

}
