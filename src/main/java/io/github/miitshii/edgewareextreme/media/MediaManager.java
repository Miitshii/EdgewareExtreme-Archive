package io.github.miitshii.edgewareextreme.media;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MediaManager {

    private static final List<String> VLCJ_EXTENSIONS_VIDEO = Arrays.asList("3g2", "3gp", "3gp2", "3gpp", "amv", "asf", "avi", "bik", "bin", "divx", "drc", "dv", "evo", "f4v", "flv", "gvi", "gxf", "iso", "m1v", "m2v", "m2t", "m2ts", "m4v", "mkv", "mov", "mp2", "mp2v", "mp4", "mp4v", "mpe", "mpeg", "mpeg1", "mpeg2", "mpeg4", "mpg", "mpv2", "mts", "mtv", "mxf", "mxg", "nsv", "nuv", "ogg", "ogm", "ogv", "ogx", "ps", "rec", "rm", "rmvb", "rpl", "thp", "tod", "ts", "tts", "txd", "vob", "vro", "webm", "wm", "wmv", "wtv", "xesc");
    private static final List<String> VLCJ_EXTENSIONS_AUDIO = Arrays.asList("3ga", "669", "a52", "aac", "ac3", "adt", "adts", "aif", "aifc", "aiff", "amb", "amr", "aob", "ape", "au", "awb", "caf", "dts", "flac", "it", "kar", "m4a", "m4b", "m4p", "m5p", "mid", "mka", "mlp", "mod", "mpa", "mp1", "mp2", "mp3", "mpc", "mpga", "mus", "oga", "ogg", "oma", "opus", "qcp", "ra", "rmi", "s3m", "sid", "spx", "tak", "thd", "tta", "voc", "vqf", "w64", "wav", "wma", "wv", "xa", "xm");

    private List<URI> jfxVideos = new ArrayList<>();
    private List<URI> vlcjVideos = new ArrayList<>();
    private List<URI> jfxAudios = new ArrayList<>();
    private List<URI> vlcjAudios = new ArrayList<>();
    private List<URI> jLabelImage = new ArrayList<java.net.URI>();

    public MediaManager() {
        EdgewareExtreme.$.getSettingsModel().mediaPathListeners.add(newValue -> loadMedia());
        loadMedia();
    }

    public void loadMedia() {
        jfxVideos.clear();
        vlcjVideos.clear();
        jfxAudios.clear();
        vlcjAudios.clear();
        jLabelImage.clear();

        File mediaDir = new File(EdgewareExtreme.$.getSettingsModel().getMediaPath());
        if (!mediaDir.exists()) mediaDir.mkdirs();
        loadMediaRecursively(mediaDir);
    }

    private void loadMediaRecursively(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                loadMediaRecursively(file);
            } else {
                String lowerName = file.getName().toLowerCase();
                String extension = lowerName.substring(lowerName.lastIndexOf(".")+1);
                switch (extension) {
                    case "jpg": case "jpeg": case "png": case "gif":
                        jLabelImage.add(file.toURI());
                        break;
                    case "aiff": case "hls": case "mp3":
                        jfxAudios.add(file.toURI());
                        break;
                    case "fxm": case "flv": case "mp4":
                        jfxVideos.add(file.toURI());
                        break;
                }
                if (VLCJ_EXTENSIONS_AUDIO.contains(extension)) {
                    vlcjAudios.add(file.toURI());
                }
                if (VLCJ_EXTENSIONS_VIDEO.contains(extension)) {
                    vlcjVideos.add(file.toURI());
                }
            }
        }
    }

    public URI getRandomJFXVideo() {
        Random r = new Random();
        return jfxVideos.get(r.nextInt(jfxVideos.size()));
    }

    public URI getRandomVLCJVideo() {
        Random r = new Random();
        return vlcjVideos.get(r.nextInt(vlcjVideos.size()));
    }

    public URI getRandomJLabelImage() {
        Random r = new Random();
        return jLabelImage.get(r.nextInt(jLabelImage.size()));
    }

}
