package io.github.miitshii.edgewareextreme.configUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class JLinkLabel extends JLabel {

    public JLinkLabel(String text, String link) {
        super("<html><a href>"+text+"</a></html>");
        setToolTipText(link);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(link));
                } catch (Exception ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showInputDialog("Couldn't open this link", link);
                }
            }
        });
    }

}
