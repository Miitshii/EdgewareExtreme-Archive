package io.github.miitshii.edgewareextreme.events;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;
import io.github.miitshii.edgewareextreme.annoyanceUI.AnnoyanceWindow;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class AnnoyanceEvent implements IEvent {

    private transient boolean isWorking = false;
    private transient TimerTask delayTask;

    @Override
    public void executeEvent(Timeline timeline) {
        System.out.println("Annoyance Event executed!");
        Double chance = EdgewareExtreme.$.getSettingsModel().getAnnoyanceFrequency();
        Random r = new Random();
        if (r.nextDouble() <= chance/100D) {
            isWorking = true;

            new AnnoyanceWindow();

            Timer t = new Timer();
            if (delayTask != null) delayTask.cancel();
            t.schedule(delayTask = new TimerTask() {
                @Override
                public void run() {
                    isWorking = false;
                    System.out.println("Annoyance Event done!");
                }
            }, (long) EdgewareExtreme.$.getSettingsModel().getAnnoyanceDelay().doubleValue());
        }
    }

    @Override
    public boolean isWorking() {
        return isWorking;
    }

    @Override
    public void cancelEvent() {
        isWorking = false;
        if (delayTask != null) delayTask.cancel();
    }

}
