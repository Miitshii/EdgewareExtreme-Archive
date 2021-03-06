package io.github.miitshii.edgewareextreme.settings;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SettingPanic extends AbstractSetting<Object> {

    public static JTextField INPUT_INSTANCE;

    private JLabel label;
    private JTextField input;
    private JCheckBox checkbox;

    public SettingPanic(JPanel container, GridBagLayout gbl, int gridY) {
        try {
            EdgewareExtreme.$.getSettingsModel().panicButtonListeners.add(newValue -> SettingPanic.this.onUpdated(null));
            EdgewareExtreme.$.getSettingsModel().panicButtonModifiersListeners.add(newValue -> SettingPanic.this.onUpdated(null));
            EdgewareExtreme.$.getSettingsModel().panicButtonEnabledListeners.add(newValue -> SettingPanic.this.onUpdated(null));

            container.add(label = new JLabel("Panic Button"));
            gbl.setConstraints(label, new BasicGBC(0, gridY, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST));

            input = new JTextField(panicToString());
            INPUT_INSTANCE = input;
            gbl.setConstraints(input, new BasicGBC(1, gridY, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
            container.add(input);
            input.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() != KeyEvent.VK_SHIFT
                        && e.getKeyCode() != KeyEvent.VK_CONTROL
                        && e.getKeyCode() != KeyEvent.VK_ALT
                        && e.getKeyCode() != KeyEvent.VK_ALT_GRAPH) {
                        // we typed a proper character
                        changeValue(e.getExtendedKeyCode(), e.getModifiersEx(), true);
                    } else {
                        changeValue(KeyEvent.VK_UNDEFINED, e.getModifiersEx(), true);
                    }
                    e.consume();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }
            });

            checkbox = new JCheckBox("Enabled", EdgewareExtreme.$.getSettingsModel().getPanicButtonEnabled());
            gbl.setConstraints(checkbox, new BasicGBC(2, gridY, 1, 1, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.EAST));
            checkbox.addChangeListener(e -> {
                EdgewareExtreme.$.getSettingsModel().setPanicButtonEnabled(checkbox.isSelected());
                EdgewareExtreme.$.getSettingsManager().saveConfig();
            });
            container.add(checkbox);
        } catch (Exception e) {
            // should never happen
            e.printStackTrace();
        }
    }

    public String panicToString() {
        Integer key = EdgewareExtreme.$.getSettingsModel().getPanicButton();
        Integer modifiers = EdgewareExtreme.$.getSettingsModel().getPanicButtonModifiers();
        return (modifiers != 0 ? KeyEvent.getModifiersExText(modifiers) : "")
                + (key != KeyEvent.VK_UNDEFINED && modifiers != 0 ? " + " : "")
                + (key != KeyEvent.VK_UNDEFINED ? KeyEvent.getKeyText(key) : "");
    }

    public void changeValue(Integer key, Integer modifiers, boolean save) {
        EdgewareExtreme.$.getSettingsModel().setPanicButton(key);
        EdgewareExtreme.$.getSettingsModel().setPanicButtonModifiers(modifiers);
        input.setText(panicToString());

        if (save) {
            EdgewareExtreme.$.getSettingsManager().saveConfig();
        }
    }

    @Override
    public void onUpdated(Object newValue) {
        try {
            input.setText(panicToString());
            input.setEnabled(EdgewareExtreme.$.getSettingsModel().getPanicButtonEnabled());
            checkbox.setSelected(EdgewareExtreme.$.getSettingsModel().getPanicButtonEnabled());
        } catch (Exception e) {
            // should never happen
            e.printStackTrace();
        }
    }

}
