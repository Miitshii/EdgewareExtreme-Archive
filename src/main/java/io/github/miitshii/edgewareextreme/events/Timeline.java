package io.github.miitshii.edgewareextreme.events;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class Timeline extends Thread {

    @Getter
    private List<IEvent> originalQueue = new ArrayList<>();
    // only do this in init!
    public void addToOriginalQueue(IEvent event) {
        originalQueue.add(event);
    }

    private transient List<IEvent> currentQueue = new ArrayList<>();

    private transient boolean running = false;
    private transient int atCurrentEntry = 0;

    public Timeline() {
    }

    @Override
    public synchronized void start() {
        if (running) return;
        super.start();
        running = true;
        currentQueue = originalQueue;
    }

    @Override
    public void run() {
        while (running) {
            if (atCurrentEntry >= currentQueue.size()) {
                // reached end, reset
                currentQueue = originalQueue;
                atCurrentEntry = 0;
            }

            IEvent currentEvent = getCurrentEvent();
            currentEvent.executeEvent(this);
            while (currentEvent.isWorking()) {
                ; // wait
            }
            atCurrentEntry++;
        }
    }

    public IEvent getCurrentEvent() {
        return currentQueue.get(atCurrentEntry);
    }

    public void addToQueue(IEvent add, IEvent parent) {
        currentQueue.add(currentQueue.indexOf(parent)+1, add);
    }

    public void stopAll() {
        running = false;
        getCurrentEvent().cancelEvent();
        currentQueue = originalQueue;
    }

}
