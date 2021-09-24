package io.github.miitshii.edgewareextreme.annoyanceUI;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Random;

public abstract class AnnoyanceWindow extends JDialog {

    public AnnoyanceWindow() {
        EdgewareExtreme.$.getPanicPerformedListeners().add(() -> panic());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setAlwaysOnTop(true);
    }

    public void setAutoSizeAndLocation(int width, int height) {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = graphicsEnvironment.getScreenDevices();
        Random r = new Random();
        int i = r.nextInt(devices.length);
        System.out.println(i);
        GraphicsDevice device = devices[i];

        Rectangle bounds = device.getDefaultConfiguration().getBounds();
        int screenWidth = bounds.width;
        int screenHeight = bounds.height;

        // take up max 50% of dimensions - 25% of screen
        while (width >= screenWidth/2 || height >= screenHeight/2) {
            // adjust for oversized media
            width /= 2;
            height /= 2;
        }
        setSize(width, height);

        int randomX = bounds.x + r.nextInt(bounds.width-width);
        int randomY = bounds.y + r.nextInt(bounds.height-height);
        setLocation(randomX, randomY);
    }

    private void panic() {
        setVisible(false);
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
