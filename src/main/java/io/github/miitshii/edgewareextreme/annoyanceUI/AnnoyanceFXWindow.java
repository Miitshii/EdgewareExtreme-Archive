package io.github.miitshii.edgewareextreme.annoyanceUI;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AnnoyanceFXWindow extends Stage {

    protected static volatile List<AnnoyanceFXWindowVideo> VIDEOS = new ArrayList<>();

    /**
     *
     * @throws Exception literally anything could go wrong with media
     */
    public AnnoyanceFXWindow() throws Exception {
        EdgewareExtreme.$.getPanicPerformedListeners().add(() -> close());
        initStyle(StageStyle.UNDECORATED);
        setAlwaysOnTop(true);
    }

    public void setAutoSizeAndLocation(int width, int height) {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = graphicsEnvironment.getScreenDevices();
        Random r = new Random();
        int i = r.nextInt(devices.length);
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
        setWidth(width);
        setHeight(height);

        int randomX = bounds.x + r.nextInt(bounds.width-width);
        int randomY = bounds.y + r.nextInt(bounds.height-height);
        setX(randomX);
        setY(randomY);
    }

    @Override
    public void close() {
        Platform.runLater(() -> {
            super.close();
        });
    }

}
