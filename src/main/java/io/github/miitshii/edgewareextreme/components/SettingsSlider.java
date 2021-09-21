package io.github.miitshii.edgewareextreme.components;

import javax.swing.*;
import java.awt.*;

public class SettingsSlider extends JPanel {

    private JLabel text;
    private JSlider slider;
    private JSpinner spinner;

    public SettingsSlider(String text, double min, double max, GridBagLayout gbl, int gridY) {
        add(this.text = new JLabel(text));
        gbl.setConstraints(this.text, new BasicGBC(0, gridY, 1, 1));

        add(slider = new JSlider((int)min, (int) max));
        slider.addChangeListener(e -> spinner.setValue(slider.getValue()));
        gbl.setConstraints(slider, new BasicGBC(1, gridY, 1, 1));

        add(spinner = new JSpinner());
        spinner.setModel(new SpinnerNumberModel(20, min, max, 1));
        spinner.addChangeListener(e -> slider.setValue((int) spinner.getValue()));
        gbl.setConstraints(spinner, new BasicGBC(2, gridY, 1, 1));
    }

}
