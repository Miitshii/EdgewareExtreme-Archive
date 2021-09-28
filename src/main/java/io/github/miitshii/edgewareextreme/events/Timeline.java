package io.github.miitshii.edgewareextreme.events;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.miitshii.edgewareextreme.EdgewareExtreme;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public abstract class Timeline extends Thread {

    @Getter
    private List<IEvent> originalQueue = new ArrayList<>();
    // only do this in init!
    public void addToOriginalQueue(IEvent event) {
        originalQueue.add(event);
        currentQueue.add(event);
    }

    private transient List<IEvent> currentQueue = new ArrayList<>();

    private transient boolean running = false;
    private transient int atCurrentEntry = 0;

    public Timeline() {
        super("Timeline Thread");
        EdgewareExtreme.$.getPanicPerformedListeners().add(this::stopAll);
        start();
    }

    public void startQueue() {
        if (running) return;
        System.out.println("Starting Timeline Queue");
        running = true;
        currentQueue = new ArrayList<>(originalQueue);
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Running!");
        while (true) {
            Thread.sleep(1); // 100 times a sec ; otherwise thread will get stuck?
            if (running) {
                if (atCurrentEntry >= currentQueue.size()) {
                    // reached end, reset
                    currentQueue = new ArrayList<>(originalQueue);
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
    }

    public IEvent getCurrentEvent() {
        return currentQueue.get(atCurrentEntry);
    }

    public void addToQueue(IEvent add, IEvent parent) {
        currentQueue.add(currentQueue.indexOf(parent)+1, add);
    }

    public synchronized void stopAll() {
        System.out.println("Stopping Timeline");
        running = false;
        getCurrentEvent().cancelEvent();
        currentQueue = new ArrayList<>(originalQueue);
        atCurrentEntry = 0;
    }

}
