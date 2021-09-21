package io.github.miitshii.edgewareextreme.settings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;

public class GsonSettings {

    public static final GsonSettings INSTANCE = new GsonSettings();
    public static final GsonSettings $ = INSTANCE;
    private static final String FILENAME = "edgewareExtreme.json";

    public static GsonSettingsModel M;

    public GsonSettings() {
        loadConfig();
    }

    private void loadConfig() {
        try {
            File f = new File(FILENAME);
            if (f.exists()) {
                JsonReader reader = new JsonReader(new FileReader(f));
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                M = gson.fromJson(reader, GsonSettingsModel.class);
                if (M == null) {
                    M = new GsonSettingsModel();
                }
            } else {
                M = new GsonSettingsModel();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveConfig() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter fw = new FileWriter(new File(FILENAME));
            gson.toJson(M, GsonSettingsModel.class, fw);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
