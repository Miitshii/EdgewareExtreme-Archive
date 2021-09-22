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
    private int configGridY = 0;

    public ConfigWindowSettings() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(layout = new GridBagLayout());

        setupGeneralSettings();
        setupAnnoyanceSettings();
    }

    private void setupGeneralSettings() {
        JPanel generalSettings = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        generalSettings.setLayout(gbl);
        generalSettings.setBorder(new CompoundBorder(new TitledBorder(BorderFactory.createLineBorder(UIManager.getColor("Borders.color")), "General Settings"), new EmptyBorder(5, 5, 5, 5)));

        int gridy = 0;
        JLabel panicLabel = new JLabel("Panic Key:");
        gbl.setConstraints(panicLabel, new BasicGBC(0, gridy, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST));
        JButton changePanicKey = new JButton();
        

        add(generalSettings);
        layout.setConstraints(generalSettings, new BasicGBC(0, configGridY++, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH));
    }

    private void setupAnnoyanceSettings() {
        JPanel annoyanceSettings = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        annoyanceSettings.setLayout(gbl);
        annoyanceSettings.setBorder(new CompoundBorder(new TitledBorder(BorderFactory.createLineBorder(UIManager.getColor("Borders.color")), "Image Annoyance"), new EmptyBorder(5, 5, 5, 5)));

        int gridy = 0;
        new SettingsSlider(GsonSettings.M::getAnnoyanceDelay, GsonSettings.M::setAnnoyanceDelay, "Time Delay (ms)", 10, 60000, annoyanceSettings, gbl, gridy++);
        new SettingsSlider(GsonSettings.M::getAnnoyanceFrequency, GsonSettings.M::setAnnoyanceFrequency, "Popup Frequency (%)", 0, 100, annoyanceSettings, gbl, gridy++);
        new SettingsSlider(GsonSettings.M::getAnnoyanceTimeout, GsonSettings.M::setAnnoyanceTimeout, "Popup Timeout (ms)", -1, 60000, annoyanceSettings, gbl, gridy++);
        new SettingsSlider(GsonSettings.M::getAnnoyanceMitosis, GsonSettings.M::setAnnoyanceMitosis, "Mitosis Amount", -1, 10, annoyanceSettings, gbl, gridy++);

        add(annoyanceSettings);
        layout.setConstraints(annoyanceSettings, new BasicGBC(0, configGridY++, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH));
    }

}
