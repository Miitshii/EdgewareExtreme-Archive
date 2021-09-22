package io.github.miitshii.edgewareextreme.settings;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public abstract class AbstractSetting<V> extends JPanel {

    public static final List<AbstractSetting> allSettings = new ArrayList<>();

    private Callable<V> get;
    private Consumer<V> set;

    public static List<AbstractSetting> getAllSettings() {
        return allSettings;
    }

    public Callable<V> getGet() {
        return get;
    }

    public V getValue() throws Exception {
        return getGet().call();
    }

    public void setGet(Callable<V> get) {
        this.get = get;
    }

    public Consumer<V> getSet() {
        return set;
    }

    public void setValue(V value) {
        getSet().accept(value);
    }

    public void setSet(Consumer<V> set) {
        this.set = set;
    }

    public abstract void update();

    {
        allSettings.add(this);
    }

}
