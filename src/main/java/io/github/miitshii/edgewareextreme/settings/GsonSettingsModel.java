package io.github.miitshii.edgewareextreme.settings;

import io.github.miitshii.edgewareextreme.settings.AbstractSetting;

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

    public void setPanicButton(Integer panicButton) {
        this.panicButton = panicButton;
        updateAll();
    }

    public Integer getPanicButtonModifiers() {
        if (panicButtonModifiers == null) return 0;
        return panicButtonModifiers;
    }

    public void setPanicButtonModifiers(Integer panicButtonModifiers) {
        this.panicButtonModifiers = panicButtonModifiers;
        updateAll();
    }

    public Boolean getPanicButtonEnabled() {
        if (panicButtonEnabled == null) return true;
        return panicButtonEnabled;
    }

    public void setPanicButtonEnabled(Boolean panicButtonEnabled) {
        this.panicButtonEnabled = panicButtonEnabled;
        updateAll();
    }

    public Double getAnnoyanceDelay() {
        if (annoyanceDelay == null) return 1000D;
        return annoyanceDelay;
    }

    public void setAnnoyanceDelay(Double annoyanceDelay) {
        this.annoyanceDelay = annoyanceDelay;
        updateAll();
    }

    public Double getAnnoyanceFrequency() {
        if (annoyanceFrequency == null) return 50D;
        return annoyanceFrequency;
    }

    public void setAnnoyanceFrequency(Double annoyanceFrequency) {
        this.annoyanceFrequency = annoyanceFrequency;
        updateAll();
    }

    public Double getAnnoyanceTimeout() {
        if (annoyanceTimeout == null) return -1D;
        return annoyanceTimeout;
    }

    public void setAnnoyanceTimeout(Double annoyanceTimeout) {
        this.annoyanceTimeout = annoyanceTimeout;
        updateAll();
    }

    public Double getAnnoyanceMitosis() {
        if (annoyanceMitosis == null) return -1D;
        return annoyanceMitosis;
    }

    public void setAnnoyanceMitosis(Double annoyanceMitosis) {
        this.annoyanceMitosis = annoyanceMitosis;
        updateAll();
    }

    public void updateAll() {
        // TODO listeners
    }

}
