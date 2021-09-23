package io.github.miitshii.edgewareextreme.config;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;
import io.github.miitshii.edgewareextreme.settings.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        new SettingPanic(generalSettings, gbl, gridy++);

        add(generalSettings);
        layout.setConstraints(generalSettings, new BasicGBC(0, configGridY++, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH));
    }

    private void setupAnnoyanceSettings() {
        JPanel annoyanceSettings = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        annoyanceSettings.setLayout(gbl);
        annoyanceSettings.setBorder(new CompoundBorder(new TitledBorder(BorderFactory.createLineBorder(UIManager.getColor("Borders.color")), "Annoyance"), new EmptyBorder(5, 5, 5, 5)));

        int gridy = 0;
        final GsonSettingsModel m = EdgewareExtreme.$.getSettingsModel();
        new SettingsSlider(m::getAnnoyanceDelay, m::setAnnoyanceDelay, m.annoyanceDelayListeners::add, "Time Delay (ms)", 10, 60000, annoyanceSettings, gbl, gridy++);
        new SettingsSlider(m::getAnnoyanceFrequency, m::setAnnoyanceFrequency, m.annoyanceFrequencyListeners::add,"Popup Frequency (%)", 0, 100, annoyanceSettings, gbl, gridy++);
        new SettingsSlider(m::getAnnoyanceTimeout, m::setAnnoyanceTimeout, m.annoyanceTimeoutListeners::add,"Popup Timeout (ms)", -1, 60000, annoyanceSettings, gbl, gridy++);
        new SettingsSlider(m::getAnnoyanceMitosis, m::setAnnoyanceMitosis, m.annoyanceMitosisListeners::add,"Mitosis Amount", 0, 10, annoyanceSettings, gbl, gridy++);

        add(annoyanceSettings);
        layout.setConstraints(annoyanceSettings, new BasicGBC(0, configGridY++, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTH));
    }

}
