package io.github.miitshii.edgewareextreme.events;

public class DefaultTimeline extends Timeline {

    public DefaultTimeline() {
        addToOriginalQueue(new HibernateEvent());
    }

}
