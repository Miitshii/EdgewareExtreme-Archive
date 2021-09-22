package io.github.miitshii.edgewareextreme.settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class SettingsSlider extends AbstractSetting<Double> {

    private JLabel label;
    private JSlider slider;
    private JSpinner spinner;

    public SettingsSlider(Callable<Double> get, Consumer<Double> set, String text, double min, double max, JPanel container, GridBagLayout gbl, int gridY) {
        try {
            setGet(get);
            setSet(set);

            container.add(label = new JLabel(text));
            gbl.setConstraints(label, new BasicGBC(0, gridY, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST));

            slider = new JSlider((int)min, (int) max, (int)getValue().doubleValue());
            gbl.setConstraints(slider, new BasicGBC(1, gridY, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
            container.add(slider);
            slider.addChangeListener(e -> changeValue(slider.getValue(), false));
            slider.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    changeValue(slider.getValue(), true);
                }
            });

            container.add(spinner = new JSpinner());
            spinner.setModel(new SpinnerNumberModel((double)getValue(), min, max, 1));
            spinner.addChangeListener(e -> changeValue((double)spinner.getValue(), true));
            gbl.setConstraints(spinner, new BasicGBC(2, gridY, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.EAST));
        } catch (Exception e) {
            // should never happen
            e.printStackTrace();
        }
    }

    public void changeValue(double newValue, boolean save) {
        slider.setValue((int) newValue);
        spinner.setValue(newValue);
        setValue(newValue);

        if (save) {
            GsonSettings.$.saveConfig();
        }
    }

    @Override
    public void update() {
        try {
            slider.setValue((int) getValue().doubleValue());
            spinner.setValue(getValue());
        } catch (Exception e) {
            // should never happen
            e.printStackTrace();
        }
    }

}
