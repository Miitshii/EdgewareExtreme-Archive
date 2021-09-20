package io.github.miitshii.edgewareextreme;

import javax.swing.*;
import java.awt.*;

public class ConfigWindow extends JFrame {

    ConfigWindow() {
        setTitle("EdgewareExtreme Config");
        Dimension size = new Dimension(800, 500);
        setSize(size);
        getContentPane().setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }

}
