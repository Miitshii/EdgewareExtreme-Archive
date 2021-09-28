package io.github.miitshii.edgewareextreme.configUI;

import io.github.miitshii.edgewareextreme.settings.BasicGBC;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.Flow;

public class ConfigWindowAbout extends JPanel {

    private GridBagLayout layout;

    public ConfigWindowAbout() {
        int gridY = 0;

        setLayout(layout = new GridBagLayout());
        JPanel about = new JPanel();
        about.setLayout(new FlowLayout());
        layout.setConstraints(about, new BasicGBC(0, gridY++, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        about.add(new JLinkLabel("EdgewareExtreme", "https://github.com/Miitshii/EdgewareExtreme"));
        about.add(new JLabel("made with ❤️and \uD83D\uDCA6 by"));
        about.add(new JLinkLabel("Miitshii", "https://github.com/Miitshii"));
        add(about);

        JPanel version = new JPanel();
        version.setLayout(new FlowLayout());
        layout.setConstraints(version, new BasicGBC(0,  gridY++, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        try {
            final Properties properties = new Properties();
            properties.load(this.getClass().getResourceAsStream("/.version"));
            version.add(new JLabel("Current Version: "+properties.getProperty("version")));
        } catch (Exception e) {
            version.add(new JLabel("Could not read version number: "+e.getMessage()));
            e.printStackTrace();
        }
        add(version);

        JPanel licenses = new JPanel();
        licenses.setLayout(new FlowLayout());
        layout.setConstraints(licenses, new BasicGBC(0, gridY++, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        licenses.add(new JLabel("Licenses:"));
        licenses.add(new JLinkLabel("Flatlaf", "https://github.com/JFormDesigner/FlatLaf/blob/main/LICENSE"));
        licenses.add(new JLinkLabel("Twemoji", "https://github.com/twitter/twemoji/blob/master/LICENSE"));
        licenses.add(new JLinkLabel("vlcj", "https://github.com/caprica/vlcj"));
        add(licenses);
    }

}
