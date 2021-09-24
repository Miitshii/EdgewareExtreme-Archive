package io.github.miitshii.edgewareextreme.annoyanceUI;

import com.sun.javafx.geom.Edge;
import io.github.miitshii.edgewareextreme.EdgewareExtreme;
import uk.co.caprica.vlcj.media.Media;
import uk.co.caprica.vlcj.media.MediaEventAdapter;
import uk.co.caprica.vlcj.media.MediaParsedStatus;
import uk.co.caprica.vlcj.media.VideoTrackInfo;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.util.Random;

public class AnnoyanceWindowVLCJ extends AnnoyanceWindow {

    public AnnoyanceWindowVLCJ() throws Exception {
        super();

        if (VIDEOS.size() >= EdgewareExtreme.$.getSettingsModel().getVideoLimit()) {
            dispose();
            throw new TooManyVideosException();
        }

        EmbeddedMediaPlayerComponent empc = new EmbeddedMediaPlayerComponent();
        getContentPane().add(empc);

        URI uri = EdgewareExtreme.$.getMediaManager().getRandomVLCJVideo();
        empc.mediaPlayer().media().prepare(uri.toString());
        empc.mediaPlayer().media().events().addMediaEventListener(new MediaEventAdapter() {
            @Override
            public void mediaParsedChanged(Media media, MediaParsedStatus newStatus) {
                VideoTrackInfo vti0 = empc.mediaPlayer().media().info().videoTracks().get(0);

                setAutoSizeAndLocation(vti0.width(), vti0.height());

                setVisible(true);
                VIDEOS.add(AnnoyanceWindowVLCJ.this);
                empc.mediaPlayer().media().play(empc.mediaPlayer().media().newMediaRef());
                empc.mediaPlayer().audio().setVolume((int) EdgewareExtreme.$.getSettingsModel().getVideoVolume().doubleValue());
                empc.mediaPlayer().controls().setRepeat(true);
            }
        });
        empc.mediaPlayer().media().parsing().parse();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                empc.mediaPlayer().release();
            }
        });
    }

}
