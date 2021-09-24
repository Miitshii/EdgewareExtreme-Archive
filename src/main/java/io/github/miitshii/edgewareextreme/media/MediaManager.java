package io.github.miitshii.edgewareextreme.media;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;

import java.io.File;

public class MediaManager {



    public MediaManager() {
        EdgewareExtreme.$.getSettingsModel().mediaPathListeners.add(newValue -> loadMedia());
        loadMedia();
    }

    public void loadMedia() {
        File mediaDir = new File(EdgewareExtreme.$.getSettingsModel().getMediaPath());

    }

}
