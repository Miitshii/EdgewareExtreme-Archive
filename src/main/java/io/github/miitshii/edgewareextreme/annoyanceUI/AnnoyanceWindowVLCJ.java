package io.github.miitshii.edgewareextreme.annoyanceUI;

import uk.co.caprica.vlcj.media.Media;
import uk.co.caprica.vlcj.media.MediaEventAdapter;
import uk.co.caprica.vlcj.media.MediaParsedStatus;
import uk.co.caprica.vlcj.media.VideoTrackInfo;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

/**
 * @Deprecated performance for annoyance seems to be bad, use sparingly!
 */
@Deprecated
public class AnnoyanceWindowVLCJ extends AnnoyanceWindow {

    public AnnoyanceWindowVLCJ() {
        super();

        EmbeddedMediaPlayerComponent empc = new EmbeddedMediaPlayerComponent();
        getContentPane().add(empc);
        String url = "D:\\Große Dateien\\rips\\rule34_hyper_muscles\\002_b412ebdccaa45889da71444c65e8bffb.jpeg";
        empc.mediaPlayer().media().prepare(url);
        empc.mediaPlayer().media().events().addMediaEventListener(new MediaEventAdapter() {
            @Override
            public void mediaParsedChanged(Media media, MediaParsedStatus newStatus) {
                VideoTrackInfo vti0 = empc.mediaPlayer().media().info().videoTracks().get(0);

                setAutoSizeAndLocation(vti0.width(), vti0.height());

                setVisible(true);
                empc.mediaPlayer().media().play(empc.mediaPlayer().media().newMediaRef());
                empc.mediaPlayer().controls().setRepeat(true);
            }
        });
        empc.mediaPlayer().media().parsing().parse();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Closed");
                empc.mediaPlayer().release();
            }
        });
    }

}
