package io.github.miitshii.edgewareextreme.settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class SettingsSlider extends AbstractSetting<Double> {

    private JLabel text;
    private JSlider slider;
    private JSpinner spinner;

    public SettingsSlider(Callable<Double> get, Consumer<Double> set, String text, double min, double max, JPanel container, GridBagLayout gbl, int gridY) {
        try {
            this.get = get;
            this.set = set;

            container.add(this.text = new JLabel(text));
            gbl.setConstraints(this.text, new BasicGBC(0, gridY, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST));

            slider = new JSlider((int)min, (int) max, (int)get.call().doubleValue());
            gbl.setConstraints(slider, new BasicGBC(1, gridY, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
            gbl.getConstraints(slider).fill = GridBagConstraints.HORIZONTAL;
            container.add(slider);
            slider.addChangeListener(e -> updateValue(slider.getValue(), false));
            slider.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    updateValue(slider.getValue(), true);
                }
            });

            container.add(spinner = new JSpinner());
            spinner.setModel(new SpinnerNumberModel((double)get.call(), min, max, 1));
            spinner.addChangeListener(e -> updateValue((double)spinner.getValue(), true));
            gbl.setConstraints(spinner, new BasicGBC(2, gridY, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.EAST));
        } catch (Exception e) {
            // should never happen
            e.printStackTrace();
        }
    }

    public void updateValue(double newValue, boolean save) {
        slider.setValue((int) newValue);
        spinner.setValue(newValue);
        set.accept(newValue);

        if (save) {
            GsonSettings.$.saveConfig();
        }
    }

    @Override
    public void update() {
        try {
            slider.setValue((int) get.call().doubleValue());
            spinner.setValue(get.call());
        } catch (Exception e) {
            // should never happen
            e.printStackTrace();
        }
    }

}
