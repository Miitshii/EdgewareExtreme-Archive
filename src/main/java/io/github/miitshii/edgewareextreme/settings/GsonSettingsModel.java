package io.github.miitshii.edgewareextreme.settings;

import java.util.ArrayList;
import java.util.List;

public class GsonSettingsModel {

    private Integer panicButton;
    private Integer panicButtonModifiers;
    private Boolean panicButtonEnabled;
    private Double annoyanceDelay;
    private Double annoyanceFrequency;
    private Double annoyanceTimeout;
    private Double annoyanceMitosis;

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
        if (panicButtonModifiers == null) return 0;
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
        if (annoyanceTimeout == null) return -1D;
        return annoyanceTimeout;
    }

    public final transient List<ISettingsListener<Double>> annoyanceTimeoutListeners = new ArrayList<>();
    public void setAnnoyanceTimeout(Double newValue) {
        this.annoyanceTimeout = newValue;
        annoyanceTimeoutListeners.forEach(setting -> setting.onUpdated(newValue));
    }

    public Double getAnnoyanceMitosis() {
        if (annoyanceMitosis == null) return -1D;
        return annoyanceMitosis;
    }

    public final transient List<ISettingsListener<Double>> annoyanceMitosisListeners = new ArrayList<>();
    public void setAnnoyanceMitosis(Double newValue) {
        this.annoyanceMitosis = newValue;
        annoyanceMitosisListeners.forEach(setting -> setting.onUpdated(newValue));
    }

}
