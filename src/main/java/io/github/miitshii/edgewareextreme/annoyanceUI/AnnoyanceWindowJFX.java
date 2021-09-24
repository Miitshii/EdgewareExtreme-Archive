package io.github.miitshii.edgewareextreme.annoyanceUI;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Random;

public class AnnoyanceWindowJFX extends AnnoyanceWindow {

    public AnnoyanceWindowJFX() throws Exception {
        super();

        if (VIDEOS.size() >= EdgewareExtreme.$.getSettingsModel().getVideoLimit()) {
            dispose();
            throw new TooManyVideosException();
        }

        JFXPanel VFXPanel = new JFXPanel();

        Media media = new Media(EdgewareExtreme.$.getMediaManager().getRandomJFXVideo().toString());
        MediaPlayer player = new MediaPlayer(media);
        MediaView viewer = new MediaView(player);

        StackPane root = new StackPane();
        Scene scene = new Scene(root);

        // resize video based on screen size
        DoubleProperty width = viewer.fitWidthProperty();
        DoubleProperty height = viewer.fitHeightProperty();
        width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
        viewer.setPreserveRatio(true);

        // add video to stackpane
        root.getChildren().add(viewer);

        VFXPanel.setScene(scene);
        setLayout(new BorderLayout());
        add(VFXPanel, BorderLayout.CENTER);

        // loop
        player.setOnEndOfMedia(() -> {
            player.seek(Duration.ZERO);
            player.play();
        });

        player.setOnReady(() -> {
            setAutoSizeAndLocation(media.getWidth(), media.getHeight());

            viewer.getMediaPlayer().play();
            viewer.getMediaPlayer().setVolume(EdgewareExtreme.$.getSettingsModel().getVideoVolume()/100D);

            setVisible(true);
            VIDEOS.add(this);
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                player.stop();
                player.dispose();
            }
        });
    }

}
