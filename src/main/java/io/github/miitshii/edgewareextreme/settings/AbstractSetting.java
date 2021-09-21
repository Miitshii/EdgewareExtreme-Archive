package io.github.miitshii.edgewareextreme.settings;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public abstract class AbstractSetting<V> extends JPanel {

    public static final List<AbstractSetting> allSettings = new ArrayList<>();

    public Callable<V> get;
    public Consumer<V> set;

    public abstract void update();

    {
        allSettings.add(this);
    }

}
