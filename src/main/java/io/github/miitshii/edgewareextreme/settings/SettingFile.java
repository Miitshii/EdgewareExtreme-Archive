package io.github.miitshii.edgewareextreme.settings;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class SettingFile extends SettingText {

    private JButton button;

    public JButton getButton() {
        return button;
    }

    public SettingFile(Callable<String> get, Consumer<String> set, String text, JPanel container, GridBagLayout gbl, int gridY) {
        super(get, set, text, container, gbl, gridY);

        container.add(button = new JButton("..."));
        gbl.setConstraints(button, new BasicGBC(2, gridY, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.EAST));
    }
}
