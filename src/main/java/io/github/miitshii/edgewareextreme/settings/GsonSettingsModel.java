package io.github.miitshii.edgewareextreme.settings;

import io.github.miitshii.edgewareextreme.settings.AbstractSetting;

public class GsonSettingsModel {

    private Double annoyanceDelay;
    private Double annoyanceFrequency;
    private Double annoyanceTimeout;
    private Double annoyanceMitosis;

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
        for (AbstractSetting setting : AbstractSetting.allSettings) {
            setting.update();
        }
        // save it literally every time??
        GsonSettings.$.saveConfig();
    }

}
