package io.github.miitshii.edgewareextreme.settings;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class SettingFile extends SettingText {

    private JFileChooser fileChooser;
    private JButton button;

    public JButton getButton() {
        return button;
    }

    public SettingFile(Callable<String> get, Consumer<String> set, Consumer<AbstractSetting<String>> addListener, String text, JPanel container, GridBagLayout gbl, int gridY) {
        super(get, set, addListener, text, container, gbl, gridY);

        fileChooser = new JFileChooser(EdgewareExtreme.$.getSettingsModel().getMediaPath());
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        container.add(button = new JButton("..."));
        button.addActionListener(e -> {
            int ret = fileChooser.showOpenDialog(EdgewareExtreme.$.getConfigWindow());
            if (ret == JFileChooser.APPROVE_OPTION) {
                changeValue(fileChooser.getSelectedFile().getAbsolutePath(), true);
            }
        });
        gbl.setConstraints(button, new BasicGBC(2, gridY, 1, 1, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.EAST));
    }
}
