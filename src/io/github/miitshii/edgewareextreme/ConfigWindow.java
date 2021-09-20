package io.github.miitshii.edgewareextreme;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;

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

        setupSystemTray();
    }

    private void setupSystemTray() {
        if (!SystemTray.isSupported()) {
            return;
        }

        // create icon and set it
        try {
            TrayIcon trayIcon = new TrayIcon(ImageIO.read(getClass().getResource("/resources/images/smiling-face-with-horns_1f608.png")), "EdgewareExtreme");
            trayIcon.setImageAutoSize(true);
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent ev) {
                    if (ev.getClickCount() == 2) {
                        setVisible(true);
                    }
                }
            });
            SystemTray systemTray = SystemTray.getSystemTray();
            systemTray.add(trayIcon);
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

}
