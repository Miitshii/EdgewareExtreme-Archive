package io.github.miitshii.edgewareextreme.events;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;

import java.sql.Time;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class HibernateEvent implements IEvent {

    private transient boolean isWorking = false;
    private transient TimerTask timerTask;

    @Override
    public void executeEvent(Timeline timeline) {
        System.out.println("Hibernate Event executed!");
        isWorking = true;

        for (int i = 0; i < EdgewareExtreme.$.getSettingsModel().getHibernateRepeats(); i++) {
            timeline.addToQueue(new AnnoyanceEvent(), HibernateEvent.this);
        }

        Timer t = new Timer();
        Random r = new Random();
        long min = (long) EdgewareExtreme.$.getSettingsModel().getHibernateTimeMin().doubleValue();
        long max = (long) EdgewareExtreme.$.getSettingsModel().getHibernateTimeMax().doubleValue();
        if (timerTask != null) timerTask.cancel();
        t.schedule(timerTask = new TimerTask() {
            @Override
            public void run() {
                isWorking = false;
                System.out.println("Hibernate Event done!");
            }
        }, Math.max(0, min + r.nextInt((int) Math.max(1, max - min))));
    }

    @Override
    public void cancelEvent() {
        isWorking = false;
        if (timerTask != null) timerTask.cancel();
    }

    @Override
    public boolean isWorking() {
        return isWorking;
    }

}
