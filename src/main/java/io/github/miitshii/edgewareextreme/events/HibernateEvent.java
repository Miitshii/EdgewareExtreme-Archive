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
                timeline.addToQueue(new AnnoyanceEvent(), HibernateEvent.this);
            }
        }, min + r.nextInt((int) (max - min)));
        isWorking = true;
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
