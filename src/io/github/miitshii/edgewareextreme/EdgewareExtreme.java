package io.github.miitshii.edgewareextreme;

import io.github.miitshii.edgewareextreme.config.ConfigWindow;

public class EdgewareExtreme {

    EdgewareExtreme() {
        new ConfigWindow(this);
    }

    public void panic() {
        System.exit(0);
    }

}
