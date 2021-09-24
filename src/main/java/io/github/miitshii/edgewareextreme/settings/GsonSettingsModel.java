package io.github.miitshii.edgewareextreme.settings;

import java.util.ArrayList;
import java.util.List;

public class GsonSettingsModel {

    private Integer panicButton;
    private Integer panicButtonModifiers;
    private Boolean panicButtonEnabled;
    private String mediaPath;
    private Double hibernateTimeMin;
    private Double hibernateTimeMax;
    private Double hibernateRepeats;
    private Double annoyanceDelay;
    private Double annoyanceFrequency;
    private Double annoyanceTimeout;
    private Double annoyanceMitosis;
    private Double videoVolume;
    private Double videoLimit;

    public Integer getPanicButton() {
        if (panicButton == null) return 0x20; // VK_SPACE
        return panicButton;
    }
    public final transient List<ISettingsListener<Integer>> panicButtonListeners = new ArrayList<>();
    public void setPanicButton(Integer newValue) {
        this.panicButton = newValue;
        panicButtonListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public Integer getPanicButtonModifiers() {
        if (panicButtonModifiers == null) return 192; // Ctrl + Shift
        return panicButtonModifiers;
    }
    public final transient List<ISettingsListener<Integer>> panicButtonModifiersListeners = new ArrayList<>();
    public void setPanicButtonModifiers(Integer newValue) {
        this.panicButtonModifiers = newValue;
        panicButtonModifiersListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public Boolean getPanicButtonEnabled() {
        if (panicButtonEnabled == null) return true;
        return panicButtonEnabled;
    }
    public final transient List<ISettingsListener<Boolean>> panicButtonEnabledListeners = new ArrayList<>();
    public void setPanicButtonEnabled(Boolean newValue) {
        this.panicButtonEnabled = newValue;
        panicButtonEnabledListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public String getMediaPath() {
        if (mediaPath == null) return "./media";
        return mediaPath;
    }
    public final transient List<ISettingsListener<String>> mediaPathListeners = new ArrayList<>();
    public void setMediaPath(String newValue) {
        this.mediaPath = newValue;
        mediaPathListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public Double getHibernateTimeMin() {
        if (hibernateTimeMin == null) return 0D;
        return hibernateTimeMin;
    }
    public final transient List<ISettingsListener<Double>> hibernateTimeMinListeners = new ArrayList<>();
    public void setHibernateTimeMin(Double newValue) {
        this.hibernateTimeMin = newValue;
        hibernateTimeMinListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public Double getHibernateTimeMax() {
        if (hibernateTimeMax == null) return 5000D;
        return hibernateTimeMax;
    }
    public final transient List<ISettingsListener<Double>> hibernateTimeMaxListeners = new ArrayList<>();
    public void setHibernateTimeMax(Double newValue) {
        this.hibernateTimeMax = newValue;
        hibernateTimeMaxListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public Double getHibernateRepeats() {
        if (hibernateRepeats == null) return 3D;
        return hibernateRepeats;
    }
    public final transient List<ISettingsListener<Double>> hibernateRepeatsListeners = new ArrayList<>();
    public void setHibernateRepeats(Double newValue) {
        this.hibernateRepeats = newValue;
        hibernateRepeatsListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public Double getAnnoyanceDelay() {
        if (annoyanceDelay == null) return 1000D;
        return annoyanceDelay;
    }
    public final transient List<ISettingsListener<Double>> annoyanceDelayListeners = new ArrayList<>();
    public void setAnnoyanceDelay(Double newValue) {
        this.annoyanceDelay = newValue;
        annoyanceDelayListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public Double getAnnoyanceFrequency() {
        if (annoyanceFrequency == null) return 50D;
        return annoyanceFrequency;
    }
    public final transient List<ISettingsListener<Double>> annoyanceFrequencyListeners = new ArrayList<>();
    public void setAnnoyanceFrequency(Double newValue) {
        this.annoyanceFrequency = newValue;
        annoyanceFrequencyListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public Double getAnnoyanceTimeout() {
        if (annoyanceTimeout == null) return 60000D;
        return annoyanceTimeout;
    }
    public final transient List<ISettingsListener<Double>> annoyanceTimeoutListeners = new ArrayList<>();
    public void setAnnoyanceTimeout(Double newValue) {
        this.annoyanceTimeout = newValue;
        annoyanceTimeoutListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public Double getAnnoyanceMitosis() {
        if (annoyanceMitosis == null) return 0D;
        return annoyanceMitosis;
    }
    public final transient List<ISettingsListener<Double>> annoyanceMitosisListeners = new ArrayList<>();
    public void setAnnoyanceMitosis(Double newValue) {
        this.annoyanceMitosis = newValue;
        annoyanceMitosisListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public Double getVideoVolume() {
        if (videoVolume == null) return 50D;
        return videoVolume;
    }
    public final transient List<ISettingsListener<Double>> videoVoluneListeners = new ArrayList<>();
    public void setVideoVolume(Double newValue) {
        this.videoVolume = newValue;
        videoVoluneListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public Double getVideoLimit() {
        if (videoLimit == null) return 5D;
        return videoLimit;
    }
    public final transient List<ISettingsListener<Double>> videoLimitListeners = new ArrayList<>();
    public void setVideoLimit(Double newValue) {
        this.videoLimit = newValue;
        videoLimitListeners.forEach(setting -> setting.onUpdated(newValue));
    }



}
