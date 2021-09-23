package io.github.miitshii.edgewareextreme.annoyanceUI;

import io.github.miitshii.edgewareextreme.EdgewareExtreme;

import javax.swing.*;
import java.util.Random;

public class AnnoyanceWindow extends JFrame {

    public AnnoyanceWindow() {
        EdgewareExtreme.$.getPanicPerformedListeners().add(() -> setVisible(false));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(200, 200);
        setLocationRelativeTo(null);
        Random r = new Random();
        setLocation(r.nextInt(1000), r.nextInt(1000));
        setVisible(true);

    }

}
