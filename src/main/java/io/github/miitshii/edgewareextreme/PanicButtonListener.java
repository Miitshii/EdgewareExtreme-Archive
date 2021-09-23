package io.github.miitshii.edgewareextreme;

import com.google.gson.Gson;
import io.github.miitshii.edgewareextreme.settings.GsonSettings;
import io.github.miitshii.edgewareextreme.settings.GsonSettingsModel;
import io.github.miitshii.edgewareextreme.settings.SettingPanic;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanicButtonListener implements NativeKeyListener {

    public PanicButtonListener() {
        try {
            // Get the logger for "com.github.kwhat.jnativehook" and set the level to warning.
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.WARNING);

            // Don't forget to disable the parent handlers.
            logger.setUseParentHandlers(false);

            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(this);
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        int modifiers = nativeKeyEvent.getModifiers() * KeyEvent.SHIFT_DOWN_MASK;
        GsonSettingsModel m = EdgewareExtreme.$.getSettingsModel();
        if (modifiers == m.getPanicButtonModifiers()) {
            if (m.getPanicButton() == 0
                || nativeKeyEvent.getRawCode() == m.getPanicButton()) {
                if (m.getPanicButtonEnabled()) {
                    if (!SettingPanic.INPUT_INSTANCE.hasFocus()) {
                        EdgewareExtreme.$.panic();
                    }
                }
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
    }

}
