package io.github.miitshii.edgewareextreme.settings;

import io.github.miitshii.edgewareextreme.settings.AbstractSetting;

public class GsonSettingsModel {

    private Double annoyanceDelay;

    public double getAnnoyanceDelay() {
        if (annoyanceDelay == null) return 1000;
        return annoyanceDelay;
    }

    public void setAnnoyanceDelay(Double annoyanceDelay) {
        this.annoyanceDelay = annoyanceDelay;
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
