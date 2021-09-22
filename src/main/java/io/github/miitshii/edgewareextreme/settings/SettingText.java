package io.github.miitshii.edgewareextreme.settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class SettingText extends AbstractSetting<String> {

    private JLabel label;
    private JTextField input;

    public JTextField getInput() {
        return input;
    }

    public SettingText(Callable<String> get, Consumer<String> set, String text, JPanel container, GridBagLayout gbl, int gridY) {
        try {
            setGet(get);
            setSet(set);

            container.add(label = new JLabel(text));
            gbl.setConstraints(label, new BasicGBC(0, gridY, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST));

            input = new JTextField(getValue());
            gbl.setConstraints(input, new BasicGBC(1, gridY, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
            container.add(input);
            input.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    changeValue(input.getText(), true);
                }
            });
        } catch (Exception e) {
            // should never happen
            e.printStackTrace();
        }
    }

    public void changeValue(String newValue, boolean save) {
        input.setText(newValue);
        setValue(newValue);

        if (save) {
            GsonSettings.$.saveConfig();
        }
    }

    @Override
    public void update() {
        try {
            input.setText(getValue());
        } catch (Exception e) {
            // should never happen
            e.printStackTrace();
        }
    }

}
