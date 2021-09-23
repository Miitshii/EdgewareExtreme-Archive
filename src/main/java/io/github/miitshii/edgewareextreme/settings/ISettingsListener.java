package io.github.miitshii.edgewareextreme.settings;

public interface ISettingsListener<V> {

    void onUpdated(V newValue);

}
