package io.github.miitshii.edgewareextreme.config;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ConfigWindow extends JFrame {

    private ConfigWindowContent configWindowContent;

    public ConfigWindow() {
        setTitle("EdgewareExtreme Config");
        try {
            setIconImage(ImageIO.read(getClass().getResourceAsStream("/images/smiling-face-with-horns_1f608.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Dimension size = new Dimension(800, 500);
        setSize(size);
        setContentPane(configWindowContent = new ConfigWindowContent());
        getContentPane().setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);

        setupSystemTray();
    }

    private void setupSystemTray() {
        if (!SystemTray.isSupported()) {
            // this is fine.
            return;
        }

        // create icon and set it
        try {
            TrayIcon trayIcon = new TrayIcon(getIconImage(), "EdgewareExtreme");
            trayIcon.setImageAutoSize(true);
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent ev) {
                    if (ev.getClickCount() == 2) {
                        setVisible(true);
                    }
                }
            });

            PopupMenu popupMenu = new PopupMenu();

            MenuItem openConfig = new MenuItem("Config");
            openConfig.addActionListener(e -> setVisible(true));
            popupMenu.add(openConfig);

            MenuItem performPanic = new MenuItem("Panic");
            performPanic.addActionListener(e -> EdgewareExtreme.$.panic());
            popupMenu.add(performPanic);

            trayIcon.setPopupMenu(popupMenu);

            SystemTray systemTray = SystemTray.getSystemTray();
            systemTray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
