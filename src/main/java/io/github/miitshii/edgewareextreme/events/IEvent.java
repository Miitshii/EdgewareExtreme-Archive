package io.github.miitshii.edgewareextreme.events;

public interface IEvent {

    void executeEvent(Timeline timeline);
    boolean isWorking();
    void cancelEvent();

}
