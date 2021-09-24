package io.github.miitshii.edgewareextreme.annoyanceUI;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AnnoyanceWindowJLabel extends AnnoyanceWindow {

    public AnnoyanceWindowJLabel() throws Exception {
        super();

        BufferedImage bufferedImage = ImageIO.read(EdgewareExtreme.$.getMediaManager().getRandomJLabelImage().toURL());
        setAutoSizeAndLocation(bufferedImage.getWidth(), bufferedImage.getHeight());

        Image resizedImage = bufferedImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(resizedImage));
        label.setSize(getSize());
        add(label);

        setVisible(true);
    }

}
